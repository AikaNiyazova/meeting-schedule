package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.service.EmployeeService;
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
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDto employeeDto) {
        try {
            log.info("Saving employee.");
            return ResponseEntity.ok(employeeService.save(employeeDto));
        } catch (RuntimeException ex) {
            log.error("Saving employee failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
