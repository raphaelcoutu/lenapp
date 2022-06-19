package com.raphaelcoutu.lenapp.mapper;

import com.raphaelcoutu.lenapp.dto.AccountDto;
import com.raphaelcoutu.lenapp.dto.AccountListDto;
import com.raphaelcoutu.lenapp.entity.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    AccountListDto entityToListDto(Account entity);
    AccountDto entityToDto(Account entity);

    Iterable<AccountListDto> entitiesToListDto(Iterable<Account> entities);
}
