package kg.megalab.meetingschedule.model.entity;

import kg.megalab.meetingschedule.model.enums.MeetingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_meeting")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "meeting_topic", nullable = false)
    String meetingTopic;

    @Column(name = "description")
    String description;

    @Column(name = "meeting_date", nullable = false)
    LocalDate meetingDate;

    @Column(name = "meeting_start_time", nullable = false)
    LocalTime meetingStartTime;

    @Column(name = "meeting_end_time", nullable = false)
    LocalTime meetingEndTime;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false)
    LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    Room room;

    @Column(name = "meeting_status", nullable = false)
    MeetingStatus meetingStatus;

}
