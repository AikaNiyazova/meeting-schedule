package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.RoomDto;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {

    RoomDto create(RoomDto roomDto); //TODO: CreateRoomRequest request ???

    RoomDto findById(Long id);

    RoomDto update(RoomDto roomDto);

    RoomDto save(RoomDto roomDto);

}
