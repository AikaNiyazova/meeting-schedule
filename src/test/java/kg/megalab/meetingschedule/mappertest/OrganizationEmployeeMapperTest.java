package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.OrganizationEmployeeMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import kg.megalab.meetingschedule.model.entity.OrganizationEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrganizationEmployeeMapperTest {

    @Test
    public void testOrganizationEmployeeMapper(){

        OrganizationDto organizationDto = new OrganizationDto();
        EmployeeDto employeeDto = new EmployeeDto();

        OrganizationEmployeeDto organizationEmployeeDto = new OrganizationEmployeeDto();
        organizationEmployeeDto.setId(1L);
        organizationEmployeeDto.setOrganization(organizationDto);
        organizationEmployeeDto.setEmployee(employeeDto);

        OrganizationEmployee organizationEmployee = OrganizationEmployeeMapper.INSTANCE.toEntity(organizationEmployeeDto);
        OrganizationEmployeeDto result = OrganizationEmployeeMapper.INSTANCE.toDto(organizationEmployee);

        assertEquals(organizationEmployee.getId(), result.getId());
        assertEquals(organizationEmployee.getOrganization(), result.getOrganization());
        assertEquals(organizationEmployee.getEmployee(), result.getEmployee());

    }

}
