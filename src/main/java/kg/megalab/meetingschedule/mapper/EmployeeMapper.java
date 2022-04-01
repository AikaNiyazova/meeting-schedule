package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDto> {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

}
