package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.RoomMapper;
import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.model.entity.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RoomMapperTest {

    @Test
    public void testRoomMapper(){


        RoomDto roomDto = new RoomDto();
        roomDto.setId(1L);
        roomDto.setRoomNumber("10");
        roomDto.setRoomCapacity(40);
        roomDto.setParentBuilding(null);

        Room room = RoomMapper.INSTANCE.toEntity(roomDto);
        RoomDto result = RoomMapper.INSTANCE.toDto(room);

        assertEquals(room.getId(), result.getId());
        assertEquals(room.getRoomNumber(), result.getRoomNumber());
        assertEquals(room.getRoomCapacity(), result.getRoomCapacity());
        assertEquals(room.getParentBuilding(), result.getParentBuilding());

    }

}
