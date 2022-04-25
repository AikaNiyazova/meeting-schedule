package kg.megalab.meetingschedule.repository;

import kg.megalab.meetingschedule.model.entity.Employee;
import kg.megalab.meetingschedule.model.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Boolean existsByEmployeeStatus(EmployeeStatus employeeStatus);


    default Boolean existsByEmployeeStatusIsActive(EmployeeStatus employeeStatus) {
        return existsByEmployeeStatus(EmployeeStatus.ACTIVE);
    }

    default Boolean existsByEmployeeStatusIsOnLeave(EmployeeStatus employeeStatus) {
        return existsByEmployeeStatus(EmployeeStatus.ON_LEAVE);
    }

    default Boolean existsByEmployeeStatusIsBlocked(EmployeeStatus employeeStatus) {
        return existsByEmployeeStatus(EmployeeStatus.BLOCKED);
    }

    default Boolean existsByEmployeeStatusIsDismissed(EmployeeStatus employeeStatus) {
        return existsByEmployeeStatus(EmployeeStatus.DISMISSED);
    }

    Employee findEmployeeStatusById(Long id);

    Boolean findEmployeeStatus_onLeaveById(Long id);

    Boolean findEmployeeStatus_BlockedById(Long id);

    Boolean findEmployeeStatus_DismissedById(Long id);

//    Boolean existsByIdAndEmployeeStatus_ACTIVE(Long id, EmployeeStatus employeeStatus);
//
//    Boolean existsByEmployeeStatus_DISMISSED(EmployeeStatus employeeStatus);

//    default Boolean findEmployeeStatus_OnLeaveById() {
//        findEmployeeStatusById.
//        return EmployeeStatus.ON_LEAVE
//        ById.(EmployeeStatus.ON_LEAVE)
//    }
}
