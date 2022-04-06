package kg.megalab.meetingschedule.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;
    String lastName;
    String firstName;
    String email;
    String msisdn;
    String employeeStatus;
    AccountDto account;

}
