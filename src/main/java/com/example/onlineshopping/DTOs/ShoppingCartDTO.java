package com.example.onlineshopping.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {
    private Long shoppingCartDTOId;
    private Long customerId;
    List<CartItemDTO> cartItems ;
}
