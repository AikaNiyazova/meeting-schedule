package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import kg.megalab.meetingschedule.service.WeekdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/weekday")
public class WeekdayController {

    private final WeekdayService weekdayService;

    @Autowired
    public WeekdayController(WeekdayService weekdayService) {
        this.weekdayService = weekdayService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding weekday with id=" + id);
            return ResponseEntity.ok(weekdayService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding weekday failed. Weekday with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody WeekdayDto weekdayDto) {
        try {
            log.info("Saving weekday.");
            return ResponseEntity.ok(weekdayService.save(weekdayDto));
        } catch (RuntimeException ex) {
            log.error("Saving weekday failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
