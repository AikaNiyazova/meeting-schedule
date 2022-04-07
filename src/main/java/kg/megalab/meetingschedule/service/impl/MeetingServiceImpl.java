package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.MeetingMapper;
import kg.megalab.meetingschedule.model.dto.MeetingDto;
import kg.megalab.meetingschedule.repository.MeetingRepository;
import kg.megalab.meetingschedule.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public MeetingDto create(MeetingDto meetingDto) {
        return null;
    }

    @Override
    public MeetingDto findById(Long id) {
        return MeetingMapper.INSTANCE
                .toDto(meetingRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Meeting with id=" + id + "not found")));
    }

    @Override
    public MeetingDto update(MeetingDto meetingDto) {
        return null;
    }

    @Override
    public MeetingDto save(MeetingDto meetingDto) {
        return MeetingMapper.INSTANCE
                .toDto(meetingRepository.save(MeetingMapper.INSTANCE
                        .toEntity(meetingDto)));
    }
}
