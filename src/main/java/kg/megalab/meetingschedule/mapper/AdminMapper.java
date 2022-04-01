package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.AdminDto;
import kg.megalab.meetingschedule.model.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper extends BaseMapper<Admin, AdminDto> {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

}
