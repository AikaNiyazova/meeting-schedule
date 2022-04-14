package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.BuildingDto;
import kg.megalab.meetingschedule.model.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuildingMapper extends BaseMapper<Building, BuildingDto> {

    BuildingMapper INSTANCE = Mappers.getMapper(BuildingMapper.class);

}
