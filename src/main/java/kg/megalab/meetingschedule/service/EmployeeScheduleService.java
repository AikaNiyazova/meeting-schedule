package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.EmployeeScheduleDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeScheduleService {

    EmployeeScheduleDto create(EmployeeScheduleDto employeeScheduleDto); //TODO: CreateEmployeeScheduleRequest request

    EmployeeScheduleDto findById(Long id);

    EmployeeScheduleDto update(EmployeeScheduleDto employeeScheduleDto);

    void save(EmployeeScheduleDto employeeScheduleDto);

}
