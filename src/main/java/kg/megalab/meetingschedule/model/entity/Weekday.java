package kg.megalab.meetingschedule.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_weekday")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Weekday {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "weekday", nullable = false, unique = true)
    String weekday;

}
