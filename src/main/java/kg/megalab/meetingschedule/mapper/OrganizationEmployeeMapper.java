package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import kg.megalab.meetingschedule.model.entity.OrganizationEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationEmployeeMapper extends BaseMapper<OrganizationEmployee, OrganizationEmployeeDto> {

    OrganizationEmployeeMapper INSTANCE = Mappers.getMapper(OrganizationEmployeeMapper.class);

}
