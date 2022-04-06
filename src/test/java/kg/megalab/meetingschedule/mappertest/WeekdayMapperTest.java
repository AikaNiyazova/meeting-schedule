package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.WeekdayMapper;
import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import kg.megalab.meetingschedule.model.entity.Weekday;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WeekdayMapperTest {

    @Test
    public void testWeekdayMapper(){

        WeekdayDto weekdayDto = new WeekdayDto();
        weekdayDto.setId(1L);
        weekdayDto.setWeekday("Friday");

        Weekday weekday = WeekdayMapper.INSTANCE.toEntity(weekdayDto);
        WeekdayDto result = WeekdayMapper.INSTANCE.toDto(weekday);

        assertEquals(weekday.getId(), result.getId());
        assertEquals(weekday.getWeekday(), result.getWeekday());

    }

}
