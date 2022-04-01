package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationEmployeeService {

    OrganizationEmployeeDto create(OrganizationEmployeeDto organizationEmployeeDto); //TODO: CreateOrganizationEmployeeRequest request ???

    OrganizationEmployeeDto findById(Long id);

    OrganizationEmployeeDto update(OrganizationEmployeeDto organizationEmployeeDto);

    void save(OrganizationEmployeeDto organizationEmployeeDto);

}
