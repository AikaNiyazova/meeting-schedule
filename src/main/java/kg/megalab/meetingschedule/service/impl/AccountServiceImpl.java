package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.AccountMapper;
import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.repository.AccountRepository;
import kg.megalab.meetingschedule.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto findById(Long id) {
        return AccountMapper.INSTANCE
                .toDto(accountRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Account with id=" + id + "not found")));
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        return AccountMapper.INSTANCE
                .toDto(accountRepository.save(AccountMapper.INSTANCE
                        .toEntity(accountDto)));
    }
}
