package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.BuildingMapper;
import kg.megalab.meetingschedule.model.dto.BuildingDto;
import kg.megalab.meetingschedule.model.entity.Building;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BuildingMapperTest {

    @Test
    public void testAccountMapper(){

        BuildingDto buildingDto = new BuildingDto();
        buildingDto.setId(1L);
        buildingDto.setBuilding("Building 1");

        Building building = BuildingMapper.INSTANCE.toEntity(buildingDto);
        BuildingDto result = BuildingMapper.INSTANCE.toDto(building);

        assertEquals(building.getId(), result.getId());
        assertEquals(building.getBuilding(), result.getBuilding());

    }

}
