package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

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
public class RoomAvailability extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    Room room;

    @ManyToOne
    @JoinColumn(name = "weekday_id", referencedColumnName = "id", nullable = false)
    Weekday weekday;

    @Column(name = "available_from", nullable = false)
    LocalTime availableFrom;

    @Column(name = "available_to", nullable = false)
    LocalTime availableTo;

}
