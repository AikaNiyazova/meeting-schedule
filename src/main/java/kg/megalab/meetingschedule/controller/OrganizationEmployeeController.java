package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.dto.OrganizationEmployeeDto;
import kg.megalab.meetingschedule.service.OrganizationEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/organization-employee")
public class OrganizationEmployeeController {

    private final OrganizationEmployeeService organizationEmployeeService;

    @Autowired
    public OrganizationEmployeeController(OrganizationEmployeeService organizationEmployeeService) {
        this.organizationEmployeeService = organizationEmployeeService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding organizationEmployee with id=" + id);
            return ResponseEntity.ok(organizationEmployeeService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding organizationEmployee failed. OrganizationEmployee with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/find-by-employee-id/{employeeId}")
    public ResponseEntity<?> findByEmployeeId(@PathVariable Long employeeId) {
        try {
            log.info("Finding organizationEmployee with employeeId=" + employeeId);
            return ResponseEntity.ok(organizationEmployeeService.findByEmployeeId(employeeId));
        } catch (RuntimeException ex) {
            log.error("Finding organizationEmployee failed. OrganizationEmployee with employeeId=" + employeeId + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrganizationEmployeeDto organizationEmployeeDto) {
        try {
            log.info("Saving organizationEmployee.");
            return ResponseEntity.ok(organizationEmployeeService.save(organizationEmployeeDto));
        } catch (RuntimeException ex) {
            log.error("Saving organizationEmployee failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
