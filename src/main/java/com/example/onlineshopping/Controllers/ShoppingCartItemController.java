package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.DTOs.CartItemDTO;
import com.example.onlineshopping.Model.Product;
import com.example.onlineshopping.Model.ShoppingCart;
import com.example.onlineshopping.Model.ShoppingCartItem;
import com.example.onlineshopping.Services.ProductService;
import com.example.onlineshopping.Services.ShoppingCartItemService;
import com.example.onlineshopping.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shoppingcartitems")
public class ShoppingCartItemController {
    private final ShoppingCartItemService shoppingCartItemService;
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartItemController(ShoppingCartItemService shoppingCartItemService, ProductService productService, ShoppingCartService shoppingCartService) {
        this.shoppingCartItemService = shoppingCartItemService;
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    //create a new shopping cart item
    @PostMapping("/create")
    public ResponseEntity<ShoppingCartItem> createShoppingCartItem(@RequestBody CartItemDTO cartItemDTO) {
        //create a new shopping cart item
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();

        //retrieve the product
        Product product = productService.getProductById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + cartItemDTO.getProductId()));
        //retrieve the shopping cart
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(cartItemDTO.getShoppingCartId())
                .orElseThrow(() -> new RuntimeException("Shopping Cart not found with ID: " + cartItemDTO.getShoppingCartId()));
         //setting the new shopping cart item
        shoppingCartItem.setProduct(product);
        shoppingCartItem.setShoppingCart(shoppingCart);
        shoppingCartItem.setQuantity(cartItemDTO.getQuantity());

        //adding the new item to its shopping cart

        return ResponseEntity.ok(shoppingCartItemService.createShoppingCartItem(shoppingCartItem));
    }

    //get all shopping cart items
    @GetMapping("/all")
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItems() {
        return ResponseEntity.ok(shoppingCartItemService.getAllShoppingCartItems());
    }

    //delete shopping cart item
    @DeleteMapping("/{id}")
    public void deleteShoppingCartItem(@PathVariable Long id) {
        shoppingCartItemService.deleteShoppingCartItem(id);
    }

    //update shopping cart item
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartItem> updateShoppingCartItem(@PathVariable Long id, @RequestBody Map<String, Integer> RequestBody) {
        int newQuantity = RequestBody.get("quantity");
        return ResponseEntity.ok(shoppingCartItemService.updateShoppingCartItem(id, newQuantity));
    }




}
