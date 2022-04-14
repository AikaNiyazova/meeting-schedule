package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.AdminMapper;
import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.model.dto.AdminDto;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import kg.megalab.meetingschedule.model.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AdminMapperTest {

    @Test
    public void testAdminMapper(){

        AdminDto adminDto = new AdminDto();
        adminDto.setId(1L);
        adminDto.setEmployee(EmployeeDto
                .builder()
                .id(1L)
                .lastName("Doe")
                .firstName("John")
                .email("john@gmail.com")
                .msisdn("0999999999")
                .employeeStatus("ACTIVE")
                .account(AccountDto.builder()
                        .id(1L)
                        .login("John")
                        .password("123")
                        .loginCount(1)
                        .build())
                .build());
        adminDto.setOrganization(OrganizationDto
                .builder()
                .id(1L)
                .organizationName("Megacom")
                .parentOrganization(null)
                .build());

        Admin admin  = AdminMapper.INSTANCE.toEntity(adminDto);
        AdminDto result = AdminMapper.INSTANCE.toDto(admin);

        assertEquals(admin.getId(), result.getId());
        assertEquals(admin.getEmployee(), result.getEmployee());
        assertEquals(admin.getOrganization(), result.getOrganization());

    }

}
