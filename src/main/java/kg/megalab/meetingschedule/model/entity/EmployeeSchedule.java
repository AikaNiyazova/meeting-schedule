package kg.megalab.meetingschedule.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "tb_employee_schedule")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "organization_employee_id", referencedColumnName = "id", nullable = false)
    OrganizationEmployee organizationEmployee;

    @ManyToOne
    @JoinColumn(name = "weekday_id", referencedColumnName = "id", nullable = false)
    Weekday weekday;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(name = "start_time", nullable = false, columnDefinition = "TIME DEFAULT '09:00'") //TODO: default does NOT work
    LocalTime startTime;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(name = "end_time", nullable = false, columnDefinition = "TIME DEFAULT '18:00'") //TODO: default does NOT work
    LocalTime endTime;

}
