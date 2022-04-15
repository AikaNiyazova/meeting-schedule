package kg.megalab.meetingschedule.model.entity;

import kg.megalab.meetingschedule.model.enums.EmployeeStatus;
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
@Table(name = "tb_employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

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

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, unique = true)
    Account account;

}
