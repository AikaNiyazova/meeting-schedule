package kg.megalab.meetingschedule.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateMeetingRequest {

    @NotBlank(message = "Meeting Topic may not be blank")
    String meetingTopic;

    String description;

    @NotNull
    LocalDate meetingDate;

    @NotNull
    LocalTime meetingStartTime;

    @NotNull
    LocalTime meetingEndTime;

    @Positive
    Long roomId;

//    @NotNull
//    @Positive
//    Long employeeId;
//
//    @NotBlank
//    String memberType;

    @NotNull
    @Positive
    Map<Long, String> participantDetails;

}
