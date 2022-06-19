package com.raphaelcoutu.lenapp.mapper;

import com.raphaelcoutu.lenapp.dto.ProductTransactionListDto;
import com.raphaelcoutu.lenapp.entity.ProductTransaction;
import org.mapstruct.Mapper;

@Mapper
public interface ProductTransactionMapper {
    ProductTransactionListDto entityToListDto(ProductTransaction entity);

    Iterable<ProductTransactionListDto> entitiesToListDto(Iterable<ProductTransaction> entities);
}
