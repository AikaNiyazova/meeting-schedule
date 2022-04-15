package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.RoomAvailabilityDto;
import kg.megalab.meetingschedule.service.RoomAvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/room-availability")
public class RoomAvailabilityController {

    private final RoomAvailabilityService roomAvailabilityService;

    @Autowired
    public RoomAvailabilityController(RoomAvailabilityService roomAvailabilityService) {
        this.roomAvailabilityService = roomAvailabilityService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding roomAvailability with id=" + id);
            return ResponseEntity.ok(roomAvailabilityService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding roomAvailability failed. RoomAvailability with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody RoomAvailabilityDto roomAvailabilityDto) {
        try {
            log.info("Saving roomAvailability.");
            return ResponseEntity.ok(roomAvailabilityService.save(roomAvailabilityDto));
        } catch (RuntimeException ex) {
            log.error("Saving roomAvailability failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

}
