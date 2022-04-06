package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_room")
public class Room extends AbstractPersistable<Long> {

    @Column(name = "room_number", nullable = false)
    String roomNumber;

    @Column(name = "room_capacity")
    Integer roomCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_building_id")
    @ToString.Exclude
    Room parentBuilding;

}
