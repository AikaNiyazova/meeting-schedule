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
@Table(name = "tb_employee_schedule")
public class EmployeeSchedule extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "organization_employee_id", referencedColumnName = "id", nullable = false)
    OrganizationEmployee organizationEmployee;

    @ManyToOne
    @JoinColumn(name = "weekday_id", referencedColumnName = "id", nullable = false)
    Weekday weekday;

    @Column(name = "start_time", nullable = false, columnDefinition = "TIME DEFAULT '09:00'")
    LocalTime startTime;

    @Column(name = "end_time", nullable = false, columnDefinition = "TIME DEFAULT '18:00'")
    LocalTime endTime;

}
