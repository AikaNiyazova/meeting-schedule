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
@Table(name = "tb_weekday")
public class Weekday extends AbstractPersistable<Long> {

    @Column(name = "weekday", nullable = false, unique = true)
    String weekday;

}
