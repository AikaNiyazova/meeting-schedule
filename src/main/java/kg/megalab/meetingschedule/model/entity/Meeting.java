package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

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
public class Meeting extends AbstractPersistable<Long> {

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
    @Column(name = "creation_date", nullable = false, updatable = false) //TODO: insertable ???
    LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    Room room;

}