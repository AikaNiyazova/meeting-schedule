package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.EmployeeMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.entity.Employee;
import kg.megalab.meetingschedule.model.enums.EmployeeStatus;
import kg.megalab.meetingschedule.repository.EmployeeRepository;
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

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        return null;
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
