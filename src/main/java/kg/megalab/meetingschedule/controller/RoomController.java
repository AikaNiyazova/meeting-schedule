package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody RoomDto roomDto) {
        try {
            log.info("Saving room.");
            return ResponseEntity.ok(roomService.save(roomDto));
        } catch (RuntimeException ex) {
            log.error("Saving room failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
