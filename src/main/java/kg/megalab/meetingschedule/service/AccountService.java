package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.AccountDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    AccountDto create(AccountDto accountDto); //TODO: CreateAccountRequest request ???

    AccountDto findById(Long id);

    AccountDto update(AccountDto accountDto);

    void save(AccountDto accountDto);

}
