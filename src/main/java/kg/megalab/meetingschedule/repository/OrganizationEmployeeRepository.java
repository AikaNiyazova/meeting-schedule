package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.OrganizationEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationEmployeeRepository extends JpaRepository<OrganizationEmployee, Long> {

    Optional<OrganizationEmployee> findByEmployeeId(Long employeeId);

}
