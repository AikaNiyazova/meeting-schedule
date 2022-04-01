package kg.megalab.meetingschedule.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomAvailabilityDto {

    Long id;
    RoomDto room;
    WeekdayDto weekday;
    LocalTime availableFrom;
    LocalTime availableTo;

}
