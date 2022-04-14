package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.RoomAvailabilityDto;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;

@Service
public interface RoomAvailabilityService {

    RoomAvailabilityDto create(RoomAvailabilityDto roomAvailabilityDto); //TODO: CreateRoomAvailabilityRequest request ???

    RoomAvailabilityDto findById(Long id);

    RoomAvailabilityDto update(RoomAvailabilityDto roomAvailabilityDto);

    RoomAvailabilityDto save(RoomAvailabilityDto roomAvailabilityDto);

    void create(Map<String, LocalTime> params);

}
