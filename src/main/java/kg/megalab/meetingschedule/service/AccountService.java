package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.model.request.CreateAccountRequest;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    AccountDto create(CreateAccountRequest request);

    AccountDto findById(Long id);

    AccountDto update(AccountDto accountDto);

    AccountDto save(AccountDto accountDto);

}
