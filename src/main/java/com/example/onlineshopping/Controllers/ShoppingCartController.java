package com.example.onlineshopping.Controllers;


import com.example.onlineshopping.Model.ShoppingCart;
import com.example.onlineshopping.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    //create new shopping cart
    @PostMapping("/create")
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        return ResponseEntity.ok(shoppingCartService.createShoppingCart(shoppingCart));
    }

    //get shopping cart by customer id
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ShoppingCart> getShoppingCartByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.ok(shoppingCartService.getShoppingCartByCustomerId(customerId));
    }

    //update shopping cart
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable Long id, @RequestBody ShoppingCart shoppingCart){
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(id, shoppingCart));
    }

    //delete shopping cart

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShoppingCart(@PathVariable Long id){
        shoppingCartService.deleteShoppingCart(id);
        return ResponseEntity.ok("Shopping Cart deleted successfully");
    }



}
