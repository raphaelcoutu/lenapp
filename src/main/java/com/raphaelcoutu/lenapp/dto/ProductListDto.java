package com.raphaelcoutu.lenapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductListDto {
    private Long id;
    private String lotNumber;
    private LocalDate expirationDate;
    private Integer balance;
}
