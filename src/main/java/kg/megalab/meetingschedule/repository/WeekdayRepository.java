package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekdayRepository extends JpaRepository<Weekday, Long> {
}
