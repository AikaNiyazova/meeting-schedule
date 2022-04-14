package kg.megalab.meetingschedule.controller;

import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            log.info("Finding account with id=" + id);
            return ResponseEntity.ok(accountService.findById(id));
        } catch (RuntimeException ex) {
            log.error("Finding account failed. Account with id=" + id + " not found.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestBody AccountDto accountDto) {
        try {
            log.info("Saving account.");
            return ResponseEntity.ok(accountService.save(accountDto));
        } catch (RuntimeException ex) {
            log.error("Saving account failed.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

}
