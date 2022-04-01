package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.RoomAvailabilityDto;
import org.springframework.stereotype.Service;

@Service
public interface RoomAvailabilityService {

    RoomAvailabilityDto create(RoomAvailabilityDto roomAvailabilityDto); //TODO: CreateRoomAvailabilityRequest request ???

    RoomAvailabilityDto findById(Long id);

    RoomAvailabilityDto update(RoomAvailabilityDto roomAvailabilityDto);

    void save(RoomAvailabilityDto roomAvailabilityDto);

}
