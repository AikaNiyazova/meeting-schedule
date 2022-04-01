package kg.megalab.meetingschedule.model.entity;

import kg.megalab.meetingschedule.model.enums.MeetingStatus;
import kg.megalab.meetingschedule.model.enums.MemberType;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_meeting_employee")
public class MeetingEmployee extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "meeting_id", referencedColumnName = "id", nullable = false)
    Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    Employee employee;

//    @ElementCollection(fetch = FetchType.EAGER) // без энтити создает нам таблицы
//    @CollectionTable(name = "meeting_statuses", joinColumns = @JoinColumn(name = "meeting_employee_id")) // TODO: ???
//    @Column(name = "meeting_statuses_id", nullable = false)
    MeetingStatus meetingStatus;

//    @ElementCollection(fetch = FetchType.EAGER) // без энтити создает нам таблицы
//    @CollectionTable(name = "member_types", joinColumns = @JoinColumn(name = "meeting_employee_id")) // TODO: ???
//    @Column(name = "member_types_id", nullable = false)
    MemberType memberType;

}
