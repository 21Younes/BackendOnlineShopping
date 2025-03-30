package com.example.onlineshopping.Services;


import com.example.onlineshopping.Model.ShoppingCart;
import com.example.onlineshopping.Model.ShoppingCartItem;
import com.example.onlineshopping.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartItemService shoppingCartItemService;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ShoppingCartItemService shoppingCartItemService){
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartItemService = shoppingCartItemService;
    }

    //create new shopping cart
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }

    //get shopping cart by customer id
    public ShoppingCart getShoppingCartByCustomerId(Long customerId){
        return shoppingCartRepository.findByCustomer_customerId(customerId);
    }

    //get shopping cart by id
    public Optional<ShoppingCart> getShoppingCartById(Long shoppingCartId){
        return Optional.ofNullable(shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new RuntimeException("Shopping Cart not found by id: " + shoppingCartId)));
    }

    //update shopping cart
    public ShoppingCart updateShoppingCart(Long shoppingCartId, ShoppingCart updatedShoppingCart){
        ShoppingCart oldShoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new RuntimeException("Shopping Cart not found by id: " + shoppingCartId));
        oldShoppingCart.setItems(updatedShoppingCart.getItems());
        return shoppingCartRepository.save(oldShoppingCart);
    }

    //delete shopping cart
    public void deleteShoppingCart(Long shoppingCartId){
        shoppingCartRepository.deleteById(shoppingCartId);
    }


    //adding item to shopping cart
    public ShoppingCart addItemToShoppingCart(Long shoppingCartId, Long shoppingCartItemId){
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new RuntimeException("Shopping Cart not found by id: " + shoppingCartId));
        ShoppingCartItem shoppingCartItem = shoppingCartItemService.getByShoppingCartId(shoppingCartItemId).orElseThrow(() -> new RuntimeException("Shopping Cart Item not found by id: " + shoppingCartItemId));
        shoppingCart.getItems().add(shoppingCartItem);
        return shoppingCartRepository.save(shoppingCart);
    }
}
