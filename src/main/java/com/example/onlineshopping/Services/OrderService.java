package com.example.onlineshopping.Services;

import com.example.onlineshopping.Model.Order;
import com.example.onlineshopping.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    //Add new Order
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    //update order
    public Order updateOrder(Long orderId, Order updatedOrder)  {
        Optional<Order> oldOrder = orderRepository.findById(orderId);
        if (oldOrder.isPresent()){
            Order order = oldOrder.get();
            order.setStatus(updatedOrder.getStatus());
            order.setTotalAmount(updatedOrder.getTotalAmount());
            return orderRepository.save(order);

        }
        else {
            throw new RuntimeException("order is not found by id : " + orderId);
        }
    }

    //delete order
    public void deleteOrder(long orderId){
        orderRepository.deleteById(orderId);
    }

    //get all orders

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    //get order by id

    public Optional<Order> getOrderById(Long orderId){
        return orderRepository.findById(orderId);
    }

    //get orders by customer id
    public List<Order> getOrdersByCustomerId(Long customerId){
        return orderRepository.findByCustomer_CustomerId(customerId);
    }


}
