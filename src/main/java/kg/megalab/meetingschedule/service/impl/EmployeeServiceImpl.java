package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.EmployeeMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.repository.EmployeeRepository;
import kg.megalab.meetingschedule.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
                        .orElseThrow(() -> new EntityNotFoundException("Employee with id=" + id + "not found")));
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
}
