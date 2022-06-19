package com.raphaelcoutu.lenapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTransactionListDto {
    private TransactionListDto transaction;
    private ProductListDto product;
    private Long quantity;
}
