package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.MeetingEmployeeDto;
import kg.megalab.meetingschedule.service.MeetingEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/meeting-employee")
public class MeetingEmployeeController {

    private final MeetingEmployeeService meetingEmployeeService;

    @Autowired
    public MeetingEmployeeController(MeetingEmployeeService meetingEmployeeService) {
        this.meetingEmployeeService = meetingEmployeeService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding meetingEmployee with id=" + id);
            return ResponseEntity.ok(meetingEmployeeService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding meetingEmployee failed. MeetingEmployee with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody MeetingEmployeeDto meetingEmployeeDto) {
        try {
            log.info("Saving meetingEmployee.");
            return ResponseEntity.ok(meetingEmployeeService.save(meetingEmployeeDto));
        } catch (RuntimeException ex) {
            log.error("Saving meetingEmployee failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
