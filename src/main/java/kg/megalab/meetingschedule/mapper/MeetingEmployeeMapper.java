package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.MeetingEmployeeDto;
import kg.megalab.meetingschedule.model.entity.MeetingEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeetingEmployeeMapper extends BaseMapper<MeetingEmployee, MeetingEmployeeDto> {

    MeetingEmployeeMapper INSTANCE = Mappers.getMapper(MeetingEmployeeMapper.class);

}
