package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.OrganizationMapper;
import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import kg.megalab.meetingschedule.repository.OrganizationRepository;
import kg.megalab.meetingschedule.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        return null;
    }

    @Override
    public OrganizationDto findById(Long id) {
        return OrganizationMapper.INSTANCE
                .toDto(organizationRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Organization with id=" + id + " not found")));
    }

    @Override
    public OrganizationDto update(OrganizationDto organizationDto) {
        return null;
    }

    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        return OrganizationMapper.INSTANCE
                .toDto(organizationRepository.save(OrganizationMapper.INSTANCE
                        .toEntity(organizationDto)));
    }
}
