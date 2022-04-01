package kg.megalab.meetingschedule.mapper;

import kg.megalab.meetingschedule.model.dto.AccountDto;
import kg.megalab.meetingschedule.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper<Account, AccountDto> {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

}
