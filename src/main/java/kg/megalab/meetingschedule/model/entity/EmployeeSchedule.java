package kg.megalab.meetingschedule.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "tb_employee_schedule")
public class EmployeeSchedule extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "organization_employee_id", referencedColumnName = "id", nullable = false)
    OrganizationEmployee organizationEmployee;

    @ManyToOne
    @JoinColumn(name = "weekday_id", referencedColumnName = "id", nullable = false)
    Weekday weekday;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HH:mm") //TODO: Why ARRAY?
    @Column(name = "start_time", nullable = false, columnDefinition = "TIME DEFAULT '09:00'")
    LocalTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HH:mm") //TODO: Why ARRAY?
    @Column(name = "end_time", nullable = false, columnDefinition = "TIME DEFAULT '18:00'")
    LocalTime endTime;

}
