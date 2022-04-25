package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.RoomAvailabilityMapper;
import kg.megalab.meetingschedule.model.dto.RoomAvailabilityDto;
import kg.megalab.meetingschedule.repository.RoomAvailabilityRepository;
import kg.megalab.meetingschedule.service.RoomAvailabilityService;
import kg.megalab.meetingschedule.service.RoomService;
import kg.megalab.meetingschedule.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;
import java.util.Map;

@Service
public class RoomAvailabilityServiceImpl implements RoomAvailabilityService {

    private final RoomAvailabilityRepository roomAvailabilityRepository;

    @Autowired
    public RoomAvailabilityServiceImpl(RoomAvailabilityRepository roomAvailabilityRepository) {
        this.roomAvailabilityRepository = roomAvailabilityRepository;
    }

    @Override
    public RoomAvailabilityDto create(RoomAvailabilityDto roomAvailabilityDto) {
        return null;
    }

    @Override
    public RoomAvailabilityDto findById(Long id) {
        return RoomAvailabilityMapper.INSTANCE
                .toDto(roomAvailabilityRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("RoomAvailability with id=" + id + " not found")));
    }

    @Override
    public RoomAvailabilityDto update(RoomAvailabilityDto roomAvailabilityDto) {
        return null;
    }

    @Override
    public RoomAvailabilityDto save(RoomAvailabilityDto roomAvailabilityDto) {
        return RoomAvailabilityMapper.INSTANCE
                .toDto(roomAvailabilityRepository.save(RoomAvailabilityMapper.INSTANCE
                        .toEntity(roomAvailabilityDto)));
    }
}
