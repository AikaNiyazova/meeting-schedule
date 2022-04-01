package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.model.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper extends BaseMapper<Room, RoomDto> {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

}
