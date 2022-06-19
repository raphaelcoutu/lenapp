package com.raphaelcoutu.lenapp.mapper;

import com.raphaelcoutu.lenapp.dto.TransactionListDto;
import com.raphaelcoutu.lenapp.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper {
    TransactionListDto entityToListDto(Transaction entity);

    Iterable<TransactionListDto> entitiesToListDto(Iterable<Transaction> entities);
}
