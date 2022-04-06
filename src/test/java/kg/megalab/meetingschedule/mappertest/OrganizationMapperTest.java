package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.OrganizationMapper;
import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import kg.megalab.meetingschedule.model.entity.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrganizationMapperTest {

    @Test
    public void testOrganizationMapper(){

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setId(1L);
        organizationDto.setOrganizationName("Megacom");
        organizationDto.setParentOrganization(null);

        Organization organization = OrganizationMapper.INSTANCE.toEntity(organizationDto);
        OrganizationDto result = OrganizationMapper.INSTANCE.toDto(organization);

        assertEquals(organization.getId(), result.getId());
        assertEquals(organization.getOrganizationName(), result.getOrganizationName());
        assertEquals(organization.getParentOrganization(), result.getParentOrganization());

    }

}
