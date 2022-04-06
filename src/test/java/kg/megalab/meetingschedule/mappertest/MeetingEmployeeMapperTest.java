package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.MeetingEmployeeMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.dto.MeetingDto;
import kg.megalab.meetingschedule.model.dto.MeetingEmployeeDto;
import kg.megalab.meetingschedule.model.entity.MeetingEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MeetingEmployeeMapperTest {

    @Test
    public void testMeetingEmployeeMapper(){

        MeetingDto meetingDto = new MeetingDto();
        EmployeeDto employeeDto = new EmployeeDto();

        MeetingEmployeeDto meetingEmployeeDto = new MeetingEmployeeDto();
        meetingEmployeeDto.setId(1L);
        meetingEmployeeDto.setMeeting(meetingDto);
        meetingEmployeeDto.setEmployee(employeeDto);
        meetingEmployeeDto.setMemberType("IP");
        meetingEmployeeDto.setMeetingStatus("PRO");

        MeetingEmployee meetingEmployee = MeetingEmployeeMapper.INSTANCE.toEntity(meetingEmployeeDto);
        MeetingEmployeeDto result = MeetingEmployeeMapper.INSTANCE.toDto(meetingEmployee);

        assertEquals(meetingEmployee.getId(), result.getId());
        assertEquals(meetingEmployee.getMeeting(), result.getMeeting());
        assertEquals(meetingEmployee.getEmployee(), result.getEmployee());
        assertEquals(meetingEmployee.getMemberType(), result.getMemberType());
        assertEquals(meetingEmployee.getMeetingStatus(), result.getMeetingStatus());

    }

}
