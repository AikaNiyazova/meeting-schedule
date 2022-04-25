package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.EmployeeScheduleMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeScheduleDto;
import kg.megalab.meetingschedule.repository.EmployeeScheduleRepository;
import kg.megalab.meetingschedule.service.EmployeeScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeScheduleServiceImpl implements EmployeeScheduleService {

    private final EmployeeScheduleRepository employeeScheduleRepository;

    @Autowired
    public EmployeeScheduleServiceImpl(EmployeeScheduleRepository employeeScheduleRepository) {
        this.employeeScheduleRepository = employeeScheduleRepository;
    }

    @Override
    public EmployeeScheduleDto create(EmployeeScheduleDto employeeScheduleDto) {
        return null;
    }

    @Override
    public EmployeeScheduleDto findById(Long id) {
        return EmployeeScheduleMapper.INSTANCE.toDto(employeeScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmployeeSchedule with id=" + id + " not found")));
    }

    @Override
    public EmployeeScheduleDto findByOrganizationEmployeeId(Long organizationEmployeeId) {
        return EmployeeScheduleMapper.INSTANCE
                .toDto(employeeScheduleRepository.findByOrganizationEmployeeId(organizationEmployeeId)
                        .orElseThrow(() -> new EntityNotFoundException("EmployeeSchedule with organizationEmployeeId=" + organizationEmployeeId + " not found")));
    }

    @Override
    public EmployeeScheduleDto update(EmployeeScheduleDto employeeScheduleDto) {
        return null;
    }

    @Override
    public EmployeeScheduleDto save(EmployeeScheduleDto employeeScheduleDto) {
        return EmployeeScheduleMapper.INSTANCE
                .toDto(employeeScheduleRepository.save(EmployeeScheduleMapper.INSTANCE.toEntity(employeeScheduleDto)));
    }
}
