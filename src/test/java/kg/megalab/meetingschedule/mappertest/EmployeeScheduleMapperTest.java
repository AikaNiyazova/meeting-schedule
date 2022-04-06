package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.EmployeeScheduleMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeScheduleDto;
import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import kg.megalab.meetingschedule.model.entity.EmployeeSchedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmployeeScheduleMapperTest {

    @Test
    public void testEmployeeScheduleMapper(){

        EmployeeScheduleDto employeeScheduleDto = new EmployeeScheduleDto();
        employeeScheduleDto.setId(1L);
        employeeScheduleDto.setOrganizationEmployee(OrganizationEmployeeDto.builder().build());
        employeeScheduleDto.setWeekday(WeekdayDto.builder().build());
        employeeScheduleDto.setStartTime(LocalTime.of(9, 0));
        employeeScheduleDto.setEndTime(LocalTime.of(18, 0));

        EmployeeSchedule employeeSchedule = EmployeeScheduleMapper.INSTANCE.toEntity(employeeScheduleDto);
        EmployeeScheduleDto result = EmployeeScheduleMapper.INSTANCE.toDto(employeeSchedule);

        assertEquals(employeeSchedule.getId(), result.getId());
        assertEquals(employeeSchedule.getOrganizationEmployee(), result.getOrganizationEmployee());
        assertEquals(employeeSchedule.getWeekday(), result.getWeekday());
        assertEquals(employeeSchedule.getStartTime(), result.getStartTime());
        assertEquals(employeeSchedule.getEndTime(), result.getEndTime());

    }

}
