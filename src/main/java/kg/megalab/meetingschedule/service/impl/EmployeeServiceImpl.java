package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.AccountMapper;
import kg.megalab.meetingschedule.mapper.EmployeeMapper;
import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.entity.Employee;
import kg.megalab.meetingschedule.model.enums.EmployeeStatus;
import kg.megalab.meetingschedule.model.request.CreateEmployeeRequest;
import kg.megalab.meetingschedule.repository.EmployeeRepository;
import kg.megalab.meetingschedule.service.AccountService;
import kg.megalab.meetingschedule.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    //    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               AccountService accountService) {

        this.employeeRepository = employeeRepository;
//        this.passwordEncoder = passwordEncoder;
        this.accountService = accountService;
    }
    @Override
    public EmployeeDto create(CreateEmployeeRequest request) {
        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email: " + request.getEmail() + " already in use");
        }

        AccountDto accountDto = accountService.findById(request.getAccountId());

        Employee employee = Employee
                .builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .msisdn(request.getMsisdn())
                .employeeStatus(EmployeeStatus.valueOf("ACTIVE"))
                .build();
        employee.setAccount(AccountMapper.INSTANCE.toEntity(accountDto));

//        Account account = Account
//                .builder()
//                .username(request.getEmail().substring(0, request.getEmail().indexOf('@')))
//                .password(accountService.create(new CreateAccountRequest()))
//                .loginCount(request.getLoginCount())
//                .build();

        accountService.save(AccountMapper.INSTANCE.toDto(employee.getAccount()));
//        accountService.save(AccountMapper.INSTANCE.toDto(account));
        employeeRepository.save(employee);

        return EmployeeMapper.INSTANCE.toDto(employee);

    }

    @Override
    public EmployeeDto findById(Long id) {
        return EmployeeMapper.INSTANCE
                .toDto(employeeRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Employee with id=" + id + " not found")));
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        return EmployeeMapper.INSTANCE
                .toDto(employeeRepository.save(EmployeeMapper.INSTANCE
                        .toEntity(employeeDto)));
    }

    @Override
    public Boolean validateIds(Set<Long> ids) {
        List<Long> invalidIds = new ArrayList<>();
        List<Long> onLeaveIds = new ArrayList<>();
        List<Long> blockedIds = new ArrayList<>();
        for (Long id : ids) {
            boolean existsById = employeeRepository.existsById(id);
            if (existsById) {
                EmployeeStatus employeeStatus = employeeRepository.findEmployeeStatusById(id).getEmployeeStatus();
                if (!employeeRepository.existsByEmployeeStatusIsDismissed(employeeStatus)) {
                    if (employeeRepository.existsByEmployeeStatusIsOnLeave(employeeStatus)) {
                        onLeaveIds.add(id);
                    }
                    else if (employeeRepository.existsByEmployeeStatusIsBlocked(employeeStatus)) {
                        blockedIds.add(id);
                    }
                }
            } else {
                invalidIds.add(id);
            }
        }
        if (!onLeaveIds.isEmpty()) {
            throw new RuntimeException("Employee(s) with id(s):" + onLeaveIds + " is(are) on leave"); // Программа не выбрасывает это исключение
        }
        if (!blockedIds.isEmpty()) {
            throw new RuntimeException("Employee(s) with id(s):" + blockedIds + " has been blocked"); // Программа не выбрасывает это исключение
        }
        if (!invalidIds.isEmpty()) {
            throw new RuntimeException("Employee(s) with id(s): " + invalidIds + " do(es) not exist");
        } else {
            return true;
        }
    }
//        for (Long id : ids) {
//            boolean existsById = employeeRepository.existsById(id);
//            if (existsById) {
//                EmployeeStatus employeeStatus = employeeRepository.findEmployeeStatusById(id).getEmployeeStatus();
//                if (employeeRepository.existsByEmployeeStatusIsActive(employeeStatus)) {
//                    return true;
//                }
//            } else {
//                invalidIds.add(id);
//            }
//        }
//        if (invalidIds.isEmpty()) {
//            return true;
//        } else {
//            throw new RuntimeException("Employee(s) with id(s): " + invalidIds + " are not available");
//        }

}
