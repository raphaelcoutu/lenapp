package com.raphaelcoutu.lenapp.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ProductTransactionKey implements Serializable {
    private Long productId;
    private Long transactionId;
}
