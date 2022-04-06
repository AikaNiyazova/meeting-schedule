package kg.megalab.meetingschedule.model.entity;

import kg.megalab.meetingschedule.model.enums.EmployeeStatus;
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
@Table(name = "tb_employee")
public class Employee extends AbstractPersistable<Long> {

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "msisdn", nullable = false, unique = true)
    String msisdn;

    @Column(name = "employee_status", nullable = false)
    EmployeeStatus employeeStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, unique = true)
    Account account;

}
