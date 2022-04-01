package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    OrganizationDto create(OrganizationDto organizationDto); //TODO: CreateOrganizationRequest request

    OrganizationDto findById(Long id);

    OrganizationDto update(OrganizationDto organizationDto);

    void save(OrganizationDto organizationDto);

}
