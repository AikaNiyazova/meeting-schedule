package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.OrganizationEmployeeMapper;
import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import kg.megalab.meetingschedule.repository.OrganizationEmployeeRepository;
import kg.megalab.meetingschedule.service.OrganizationEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrganizationEmployeeServiceImpl implements OrganizationEmployeeService {

    private final OrganizationEmployeeRepository organizationEmployeeRepository;

    @Autowired
    public OrganizationEmployeeServiceImpl(OrganizationEmployeeRepository organizationEmployeeRepository) {
        this.organizationEmployeeRepository = organizationEmployeeRepository;
    }

    @Override
    public OrganizationEmployeeDto create(OrganizationEmployeeDto organizationEmployeeDto) {
        return null;
    }

    @Override
    public OrganizationEmployeeDto findById(Long id) {
        return OrganizationEmployeeMapper.INSTANCE
                .toDto(organizationEmployeeRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("OrganizationEmployee with id=" + id + "not found")));
    }

    @Override
    public OrganizationEmployeeDto update(OrganizationEmployeeDto organizationEmployeeDto) {
        return null;
    }

    @Override
    public OrganizationEmployeeDto save(OrganizationEmployeeDto organizationEmployeeDto) {
        return OrganizationEmployeeMapper.INSTANCE
                .toDto(organizationEmployeeRepository.save(OrganizationEmployeeMapper.INSTANCE
                        .toEntity(organizationEmployeeDto)));
    }
}
