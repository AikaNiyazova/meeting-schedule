package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.RoomMapper;
import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.repository.RoomRepository;
import kg.megalab.meetingschedule.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto create(RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDto findById(Long id) {
        return RoomMapper.INSTANCE
                .toDto(roomRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Room with id=" + id + "not found")));
    }

    @Override
    public RoomDto update(RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDto save(RoomDto roomDto) {
        return RoomMapper.INSTANCE
                .toDto(roomRepository.save(RoomMapper.INSTANCE
                        .toEntity(roomDto)));
    }
}
