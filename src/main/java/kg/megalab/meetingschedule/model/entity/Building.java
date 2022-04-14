package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_building")
public class Building extends AbstractPersistable<Long> {

    @Column(name = "building", nullable = false, unique = true)
    String building;

}
