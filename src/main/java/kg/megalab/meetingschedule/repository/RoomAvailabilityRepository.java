package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.RoomAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {
}
