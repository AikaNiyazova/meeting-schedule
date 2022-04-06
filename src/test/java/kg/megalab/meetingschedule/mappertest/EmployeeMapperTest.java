package kg.megalab.meetingschedule.mappertest;

import kg.megalab.meetingschedule.mapper.EmployeeMapper;
import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.entity.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmployeeMapperTest {

    @Test
    public void testEmployeeMapper(){

        AccountDto accountDto = new AccountDto();

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setLastName("Doe");
        employeeDto.setFirstName("John");
        employeeDto.setEmail("john@gmail.com");
        employeeDto.setMsisdn("0999999999");
        employeeDto.setEmployeeStatus("A");
        employeeDto.setAccount(accountDto);

        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDto);
        EmployeeDto result = EmployeeMapper.INSTANCE.toDto(employee);

        assertEquals(employee.getId(), result.getId());
        assertEquals(employee.getLastName(), result.getLastName());
        assertEquals(employee.getFirstName(), result.getFirstName());
        assertEquals(employee.getEmail(), result.getEmail());
        assertEquals(employee.getMsisdn(), result.getMsisdn());
        assertEquals(employee.getEmployeeStatus(), result.getEmployeeStatus());
        assertEquals(employee.getAccount(), result.getAccount());

    }

}
