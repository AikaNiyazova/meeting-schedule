package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import kg.megalab.meetingschedule.model.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper extends BaseMapper<Organization, OrganizationDto> {

    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

}
