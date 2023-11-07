package com.kel5.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private String productName;
    private int quantity;
    private Long price; // Assuming price is given in its smallest unit (e.g., cents) to avoid float.
    private Long totalItemPrice;
}
