package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRespository  extends JpaRepository<ShoppingCartItem, Long > {
    ShoppingCartItem findByShoppingCartId(Long shoppingCartId);
    ShoppingCartItem findByProduct_ProductId(Long productId);


}
