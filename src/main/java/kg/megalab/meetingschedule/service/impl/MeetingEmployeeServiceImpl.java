package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.MeetingEmployeeMapper;
import kg.megalab.meetingschedule.model.dto.MeetingEmployeeDto;
import kg.megalab.meetingschedule.repository.MeetingEmployeeRepository;
import kg.megalab.meetingschedule.service.MeetingEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MeetingEmployeeServiceImpl implements MeetingEmployeeService {

    private final MeetingEmployeeRepository meetingEmployeeRepository;

    @Autowired
    public MeetingEmployeeServiceImpl(MeetingEmployeeRepository meetingEmployeeRepository) {
        this.meetingEmployeeRepository = meetingEmployeeRepository;
    }

    @Override
    public MeetingEmployeeDto create(MeetingEmployeeDto meetingEmployeeDto) {
        return null;
    }

    @Override
    public MeetingEmployeeDto findById(Long id) {
        return MeetingEmployeeMapper.INSTANCE
                .toDto(meetingEmployeeRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("MeetingEmployee with id=" + id + " not found")));
    }

    @Override
    public MeetingEmployeeDto update(MeetingEmployeeDto meetingEmployeeDto) {
        return null;
    }

    @Override
    public MeetingEmployeeDto save(MeetingEmployeeDto meetingEmployeeDto) {
        return MeetingEmployeeMapper.INSTANCE
                .toDto(meetingEmployeeRepository.save(MeetingEmployeeMapper.INSTANCE
                        .toEntity(meetingEmployeeDto)));
    }
}
