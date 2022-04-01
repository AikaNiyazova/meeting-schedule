package kg.megalab.meetingschedule.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeetingEmployeeDto {

    Long id;
    MeetingDto meeting;
    EmployeeDto employee;
    String meetingStatus;
    String memberType;

}
