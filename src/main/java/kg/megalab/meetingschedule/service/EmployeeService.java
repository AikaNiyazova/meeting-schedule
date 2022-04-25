package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto); //TODO: CreateEmployeeRequest request ???

    EmployeeDto findById(Long id);

    EmployeeDto update(EmployeeDto employeeDto);

    EmployeeDto save(EmployeeDto employeeDto);

    Boolean validateIds(Set<Long> ids);

}
