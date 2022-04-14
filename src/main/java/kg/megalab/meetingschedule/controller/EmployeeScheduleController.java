package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.EmployeeScheduleDto;
import kg.megalab.meetingschedule.service.EmployeeScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/employee-schedule")
public class EmployeeScheduleController {

    private final EmployeeScheduleService employeeScheduleService;

    @Autowired
    public EmployeeScheduleController(EmployeeScheduleService employeeScheduleService) {
        this.employeeScheduleService = employeeScheduleService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding employeeSchedule with id=" + id);
            return ResponseEntity.ok(employeeScheduleService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding employeeSchedule failed. EmployeeSchedule with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeScheduleDto employeeScheduleDto) {
        try {
            log.info("Saving employeeSchedule.");
            return ResponseEntity.ok(employeeScheduleService.save(employeeScheduleDto));
        } catch (RuntimeException ex) {
            log.error("Saving employeeSchedule failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
