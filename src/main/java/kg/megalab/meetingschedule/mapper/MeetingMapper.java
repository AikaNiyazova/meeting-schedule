package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.MeetingDto;
import kg.megalab.meetingschedule.model.entity.Meeting;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeetingMapper extends BaseMapper<Meeting, MeetingDto> {

    MeetingMapper INSTANCE = Mappers.getMapper(MeetingMapper.class);

}
