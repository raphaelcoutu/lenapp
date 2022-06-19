package com.raphaelcoutu.lenapp.mapper;

import com.raphaelcoutu.lenapp.dto.ProductListDto;
import com.raphaelcoutu.lenapp.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductListDto entityToListDto(Product entity);

    Iterable<ProductListDto> entitiesToListDto(Iterable<Product> entities);
}
