package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.EmployeeSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule, Long> {

    Optional<EmployeeSchedule> findByOrganizationEmployeeId(Long organizationEmployeeId);

}
