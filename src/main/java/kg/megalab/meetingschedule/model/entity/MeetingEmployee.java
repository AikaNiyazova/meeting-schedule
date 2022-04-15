package kg.megalab.meetingschedule.model.entity;

import kg.megalab.meetingschedule.model.enums.MeetingStatus;
import kg.megalab.meetingschedule.model.enums.MemberType;
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
@Table(name = "tb_meeting_employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeetingEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id", referencedColumnName = "id", nullable = false)
    Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    Employee employee;

    @Column(name = "member_type", nullable = false)
    MemberType memberType;

    @Column(name = "meeting_status", nullable = false)
    MeetingStatus meetingStatus;


}
