package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.EmployeeScheduleDto;
import kg.megalab.meetingschedule.model.entity.EmployeeSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrgEmployeeScheduleMapper extends BaseMapper<EmployeeSchedule, EmployeeScheduleDto> {

    OrgEmployeeScheduleMapper INSTANCE = Mappers.getMapper(OrgEmployeeScheduleMapper.class);

}
