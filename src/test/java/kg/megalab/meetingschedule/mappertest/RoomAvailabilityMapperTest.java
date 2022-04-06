package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.RoomAvailabilityMapper;
import kg.megalab.meetingschedule.model.dto.RoomAvailabilityDto;
import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import kg.megalab.meetingschedule.model.entity.RoomAvailability;
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
public class RoomAvailabilityMapperTest {

    @Test
    public void testRoomAvailabilityMapper(){

        RoomDto roomDto = new RoomDto();
        WeekdayDto weekdayDto = new WeekdayDto();

        RoomAvailabilityDto roomAvailabilityDto = new RoomAvailabilityDto();
        roomAvailabilityDto.setId(1L);
        roomAvailabilityDto.setRoom(roomDto);
        roomAvailabilityDto.setWeekday(weekdayDto);
        roomAvailabilityDto.setAvailableFrom(LocalTime.of(8, 0));
        roomAvailabilityDto.setAvailableTo(LocalTime.of(22, 0));

        RoomAvailability roomAvailability = RoomAvailabilityMapper.INSTANCE.toEntity(roomAvailabilityDto);
        RoomAvailabilityDto result = RoomAvailabilityMapper.INSTANCE.toDto(roomAvailability);

        assertEquals(roomAvailability.getId(), result.getId());
        assertEquals(roomAvailability.getRoom(), result.getRoom());
        assertEquals(roomAvailability.getWeekday(), result.getWeekday());
        assertEquals(roomAvailability.getAvailableFrom(), result.getAvailableFrom());
        assertEquals(roomAvailability.getAvailableTo(), result.getAvailableTo());

    }

}
