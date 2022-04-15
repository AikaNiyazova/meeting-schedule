package kg.megalab.meetingschedule.controller;


import kg.megalab.meetingschedule.model.dto.MeetingDto;
import kg.megalab.meetingschedule.service.MeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding meeting with id=" + id);
            return ResponseEntity.ok(meetingService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding meeting failed. Meeting with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody MeetingDto meetingDto) {
        try {
            log.info("Saving meeting.");
            return ResponseEntity.ok(meetingService.save(meetingDto));
        } catch (RuntimeException ex) {
            log.error("Saving meeting failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
