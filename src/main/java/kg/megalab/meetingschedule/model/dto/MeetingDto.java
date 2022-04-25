package kg.megalab.meetingschedule.model.dto;

import kg.megalab.meetingschedule.model.enums.MeetingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeetingDto {

    Long id;
    String meetingTopic;
    String description;
    LocalDate meetingDate;
    LocalTime meetingStartTime;
    LocalTime meetingEndTime;
    LocalDateTime creationDate;
    RoomDto room;
    String meetingStatus;

}
