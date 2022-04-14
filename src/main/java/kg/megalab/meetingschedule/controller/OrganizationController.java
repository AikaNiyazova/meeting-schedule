package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.OrganizationDto;
import kg.megalab.meetingschedule.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding organization with id=" + id);
            return ResponseEntity.ok(organizationService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding organization failed. Organization with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrganizationDto organizationDto) {
        try {
            log.info("Saving organization.");
            return ResponseEntity.ok(organizationService.save(organizationDto));
        } catch (RuntimeException ex) {
            log.error("Saving organization failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
