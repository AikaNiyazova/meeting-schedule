package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import kg.megalab.meetingschedule.model.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationEmployeeService {

    OrganizationEmployeeDto create(OrganizationEmployeeDto organizationEmployeeDto); //TODO: CreateOrganizationEmployeeRequest request ???

    OrganizationEmployeeDto findById(Long id);

    OrganizationEmployeeDto findByEmployeeId(Long employeeId);

    OrganizationEmployeeDto update(OrganizationEmployeeDto organizationEmployeeDto);

    OrganizationEmployeeDto save(OrganizationEmployeeDto organizationEmployeeDto);

}
