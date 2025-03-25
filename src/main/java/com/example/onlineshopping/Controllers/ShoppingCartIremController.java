package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.Model.ShoppingCartItem;
import com.example.onlineshopping.Services.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingcartitems")
public class ShoppingCartIremController {
    private final ShoppingCartItemService shoppingCartItemService;

    @Autowired
    public ShoppingCartIremController(ShoppingCartItemService shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }

    //create a new shopping cart item
    @PostMapping("/create")
    public ResponseEntity<ShoppingCartItem> createShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem) {
        return ResponseEntity.ok(shoppingCartItemService.createShoppingCartItem(shoppingCartItem));
    }

    //get all shopping cart items
    @GetMapping("/all")
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItems() {
        return ResponseEntity.ok(shoppingCartItemService.getAllShoppingCartItems());
    }






}
