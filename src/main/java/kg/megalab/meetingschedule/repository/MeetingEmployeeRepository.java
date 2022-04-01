package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.MeetingEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingEmployeeRepository extends JpaRepository<MeetingEmployee, Long> {
}
