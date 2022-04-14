package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.BuildingDto;
import kg.megalab.meetingschedule.service.BuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/building")
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding building with id=" + id);
            return ResponseEntity.ok(buildingService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding building failed. Building with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody BuildingDto buildingDto) {
        try {
            log.info("Saving building.");
            return ResponseEntity.ok(buildingService.save(buildingDto));
        } catch (RuntimeException ex) {
            log.error("Saving building failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
