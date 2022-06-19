package com.raphaelcoutu.lenapp.dto;

import com.raphaelcoutu.lenapp.entity.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionListDto {
    private Long id;
    private TransactionType type;
    private String confirmationNumber;
}
