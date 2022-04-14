package kg.megalab.meetingschedule.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") //TODO: Shape.STRING? Locale, TimeZone???
    @Column(name = "meeting_date", nullable = false)
    LocalDate meetingDate;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm") //TODO: Why ARRAY?
    @Column(name = "meeting_start_time", nullable = false)
    LocalTime meetingStartTime;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm") //TODO: Why ARRAY?
    @Column(name = "meeting_end_time", nullable = false)
    LocalTime meetingEndTime;

//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @CreationTimestamp // TODO: Should I use @JsonFormat here?
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss") //TODO: Shape.STRING? Locale, TimeZone???
    @Column(name = "creation_date", nullable = false, updatable = false)
    LocalDateTime creationDate;

//    @UpdateTimestamp
//    @Column(name = "modification_date", nullable = false, insertable = false)
//    LocalDateTime modificationDate;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    Room room;

}
