package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.MeetingMapper;
import kg.megalab.meetingschedule.model.dto.MeetingDto;
import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.model.entity.Meeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MeetingMapperTest {

    @Test
    public void testMeetingMapper(){

        RoomDto roomDto = new RoomDto();

        MeetingDto meetingDto = new MeetingDto();
        meetingDto.setId(1L);
        meetingDto.setMeetingTopic("Topic");
        meetingDto.setDescription(null);
        meetingDto.setMeetingDate(LocalDate.of(2022, 2, 22));
        meetingDto.setMeetingStartTime(LocalTime.of(11, 0));
        meetingDto.setMeetingEndTime(LocalTime.of(12, 0));
        meetingDto.setCreationDate(null);
        meetingDto.setRoom(RoomDto.builder()
//                .id(5L)
                .roomNumber("10")
                .roomCapacity(40)
//                .parentBuilding(null)
                .build());
        meetingDto.setMeetingStatus("IN_PROGRESS");

        Meeting meeting = MeetingMapper.INSTANCE.toEntity(meetingDto);
        MeetingDto result = MeetingMapper.INSTANCE.toDto(meeting);

        assertEquals(meeting.getId(), result.getId());
        assertEquals(meeting.getMeetingTopic(), result.getMeetingTopic());
        assertEquals(meeting.getDescription(), result.getDescription());
        assertEquals(meeting.getMeetingDate(), result.getMeetingDate());
        assertEquals(meeting.getMeetingStartTime(), result.getMeetingStartTime());
        assertEquals(meeting.getMeetingEndTime(), result.getMeetingEndTime());
        assertEquals(meeting.getCreationDate(), result.getCreationDate());
        assertEquals(meeting.getRoom(), result.getRoom());
        assertEquals(meeting.getMeetingStatus(), result.getMeetingStatus());

    }

}
