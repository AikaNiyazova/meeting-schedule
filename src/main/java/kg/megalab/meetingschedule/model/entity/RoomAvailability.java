package kg.megalab.meetingschedule.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_room_availability")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    Room room;

    @ManyToOne
    @JoinColumn(name = "weekday_id", referencedColumnName = "id", nullable = false)
    Weekday weekday;

//    @JsonDeserialize(using = LocalTimeDeserializer.class)
//    @JsonSerialize(using = LocalTimeSerializer.class)
//    @JsonFormat( pattern = "HH:mm") //TODO: Why ARRAY?
    @Column(name = "available_from", nullable = false)
    LocalTime availableFrom;

//    @JsonDeserialize(using = LocalTimeDeserializer.class)
//    @JsonSerialize(using = LocalTimeSerializer.class)
//    @JsonFormat( pattern = "HH:mm") //TODO: Why ARRAY?
    @Column(name = "available_to", nullable = false)
    LocalTime availableTo;

}
