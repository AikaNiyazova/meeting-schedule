package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.AdminDto;
import kg.megalab.meetingschedule.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding admin with id=" + id);
            return ResponseEntity.ok(adminService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding admin failed. Admin with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody AdminDto adminDto) {
        try {
            log.info("Saving admin.");
            return ResponseEntity.ok(adminService.save(adminDto));
        } catch (RuntimeException ex) {
            log.error("Saving admin failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
