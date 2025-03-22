package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.Model.OrderItem;
import com.example.onlineshopping.Services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {


 private final  OrderItemService orderItemService;
 @Autowired
    public OrderItemController(OrderItemService orderItemService) {
    this.orderItemService = orderItemService;
    }

 // Create a new order item
 @PostMapping("/create")
 public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
  OrderItem newOrderItem = orderItemService.addOrderItem(orderItem);
  return ResponseEntity.ok(newOrderItem);
 }

 // Get all order items
 @GetMapping("/all")
 public ResponseEntity<List<OrderItem>> getAllOrderItems() {
  return ResponseEntity.ok(orderItemService.getAllOrderItems());
 }

 // Get order items by order ID
 @GetMapping("/order/{orderId}")
 public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long orderId) {
  return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(orderId));
 }

 // Get a single order item by ID
 @GetMapping("/{id}")
 public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
  Optional<OrderItem> orderItem = Optional.ofNullable(orderItemService.getOrderItemById(id));
  return orderItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 // Delete an order item by ID
 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
  orderItemService.deleteOrderItem(id);
  return ResponseEntity.ok("Order item deleted successfully.");
 }
}
