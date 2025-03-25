package com.example.onlineshopping.Services;


import com.example.onlineshopping.Model.ShoppingCart;
import com.example.onlineshopping.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
    }

    //create new shopping cart
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }

    //get shopping cart by customer id
    public ShoppingCart getShoppingCartByCustomerId(Long customerId){
        return shoppingCartRepository.findByCustomer_customerId(customerId);
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

}
