package kg.megalab.meetingschedule.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {

    Long id;
    String login;
    String password;
    Integer loginCount;
    EmployeeDto employee;

}
