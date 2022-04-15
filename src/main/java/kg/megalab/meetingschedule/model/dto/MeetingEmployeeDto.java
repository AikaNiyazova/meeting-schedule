package kg.megalab.meetingschedule.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeetingEmployeeDto {

    Long id;
    MeetingDto meeting;
    EmployeeDto employee;
    String memberType;
    String meetingStatus;

}
