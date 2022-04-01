package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import kg.megalab.meetingschedule.model.entity.Weekday;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeekdayMapper extends BaseMapper<Weekday, WeekdayDto> {

    WeekdayMapper INSTANCE = Mappers.getMapper(WeekdayMapper.class);

}
