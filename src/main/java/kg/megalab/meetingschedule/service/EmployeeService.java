package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto); //TODO: CreateEmployeeRequest request ???

    EmployeeDto findById(Long id);

    EmployeeDto update(EmployeeDto employeeDto);

    void save(EmployeeDto employeeDto);

}