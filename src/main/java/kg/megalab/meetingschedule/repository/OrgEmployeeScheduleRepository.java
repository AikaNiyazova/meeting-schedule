package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.EmployeeSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgEmployeeScheduleRepository extends JpaRepository<EmployeeSchedule, Long> {
}
