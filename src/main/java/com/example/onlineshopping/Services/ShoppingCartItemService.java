package com.example.onlineshopping.Services;

import com.example.onlineshopping.Model.ShoppingCartItem;
import com.example.onlineshopping.Repository.ShoppingCartItemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartItemService {
    private final ShoppingCartItemRespository shoppingCartItemRespository;

    @Autowired
    public ShoppingCartItemService(ShoppingCartItemRespository shoppingCartItemRespository){
        this.shoppingCartItemRespository = shoppingCartItemRespository;
    }

    //create new shopping cart item
    public ShoppingCartItem createShoppingCartItem(ShoppingCartItem shoppingCartItem){
        return shoppingCartItemRespository.save(shoppingCartItem);
    }

    //get shopping cart item by shopping cart id
    public ShoppingCartItem getShoppingCartItemByShoppingCartId(Long shoppingCartId){
        return shoppingCartItemRespository.findByShoppingCartId(shoppingCartId);
    }

    //get all shopping cart items
    public java.util.List<com.example.onlineshopping.Model.ShoppingCartItem> getAllShoppingCartItems(){
        return shoppingCartItemRespository.findAll();
    }

    //get shopping cart item by product id
    public ShoppingCartItem getShoppingCartItemByProductId(Long productId){
        return shoppingCartItemRespository.findByProduct_ProductId(productId);
    }

    //update shopping cart item
    public ShoppingCartItem updateShoppingCartItem(Long shoppingCartItemId, int newQuantity){
        ShoppingCartItem oldShoppingCartItem = shoppingCartItemRespository.findById(shoppingCartItemId).orElseThrow(() -> new RuntimeException("Shopping Cart Item not found by id: " + shoppingCartItemId));
        oldShoppingCartItem.setQuantity(newQuantity);
        return shoppingCartItemRespository.save(oldShoppingCartItem);
    }

    //delete shopping cart item
    public void deleteShoppingCartItem(Long shoppingCartItemId){
        shoppingCartItemRespository.deleteById(shoppingCartItemId);
    }


    public Optional<ShoppingCartItem> getByShoppingCartId(Long shoppingCartItemId) {
        return Optional.ofNullable(shoppingCartItemRespository.findById(shoppingCartItemId).orElseThrow(() -> new RuntimeException("Shopping Cart Item not found by id: " + shoppingCartItemId)));

    }
}
