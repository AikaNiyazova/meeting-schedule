package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.RoomAvailabilityDto;
import kg.megalab.meetingschedule.model.entity.RoomAvailability;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomAvailabilityMapper extends BaseMapper<RoomAvailability, RoomAvailabilityDto> {

    RoomAvailabilityMapper INSTANCE = Mappers.getMapper(RoomAvailabilityMapper.class);

}
