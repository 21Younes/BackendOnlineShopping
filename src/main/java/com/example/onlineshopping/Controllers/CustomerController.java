package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.DTOs.*;
import com.example.onlineshopping.Model.Customer;
import com.example.onlineshopping.Model.ShoppingCart;
import com.example.onlineshopping.Services.CustomerService;
import com.example.onlineshopping.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    private CustomerService customerService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public CustomerController(CustomerService customerService, ShoppingCartService shoppingCartService) {
        this.customerService = customerService;
        this.shoppingCartService = shoppingCartService;
    }

    // Create a new customer
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        //adding the customer
        Customer newCustomer = customerService.addCustomer(customer);

        //adding the shoppingcart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(newCustomer);
        shoppingCartService.createShoppingCart(shoppingCart);
        return ResponseEntity.ok(newCustomer);
    }

    // Get all customers
    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<CustomerDTO> customerDTOS = customers.stream().map(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setUsername(customer.getUsername());
            customerDTO.setPassword(customer.getPassword());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setAge(customer.getAge());
            customerDTO.setSex(customer.getSex());

            //list of shipping addresses owned by the customer
            List<ShippingAddressDTO> shippingAddressDTOS = customer.getShippingAddresses().stream()
                    .map(shippingAddress -> {
                        ShippingAddressDTO shippingAddressDTO = new ShippingAddressDTO();
                        shippingAddressDTO.setShippingAddressId(shippingAddress.getShippindAdressId());
                        shippingAddressDTO.setStreet(shippingAddress.getStreet());
                        shippingAddressDTO.setCity(shippingAddress.getCity());
                        shippingAddressDTO.setCountry(shippingAddress.getCountry());
                        shippingAddressDTO.setPostalCode(shippingAddress.getPostalCode());
                        shippingAddressDTO.setState(shippingAddress.getState());
                        shippingAddressDTO.setPhoneNumber(shippingAddress.getPhoneNumber());
                        shippingAddressDTO.setCustomerId(shippingAddress.getCustomer().getCustomerId());
                        return shippingAddressDTO;
                    }).collect(Collectors.toList());
            customerDTO.setShippingAddresses(shippingAddressDTOS);

            //list of orders owned by the customer
            List<OrderDTO> orderDTOS = customer.getOrders().stream()
                    .map(order -> {
                        OrderDTO orderDTO = new OrderDTO();
                        orderDTO.setOrderId(order.getOrderId());
                        orderDTO.setStatus(order.getStatus());
                        orderDTO.setTotalAmount(order.getTotalAmount());
                        orderDTO.setCustomerId(order.getCustomer().getCustomerId());
                        return orderDTO;
                    }).collect(Collectors.toList());
            customerDTO.setOrders(orderDTOS);

            //list of reviews written by the customer
            List<ReviewDTO> reviewDTOS = customer.getReviews().stream()
                    .map(review -> {
                        ReviewDTO reviewDTO = new ReviewDTO();
                        reviewDTO.setRating(review.getRating());
                        reviewDTO.setComment(review.getComment());
                        reviewDTO.setProductId(review.getProduct().getProductId());
                        reviewDTO.setCustomerId(review.getCustomer().getCustomerId());
                        return reviewDTO;
                    }).collect(Collectors.toList());
            customerDTO.setReviews(reviewDTOS);

            //list of payments made by the customer
            List<PaymentDTO> paymentDTOS = customer.getPayments().stream()
                    .map(payment -> {
                        PaymentDTO paymentDTO = new PaymentDTO();
                        paymentDTO.setPaymentId(payment.getPaymentId());
                        paymentDTO.setAmount(payment.getAmount());
                        paymentDTO.setPaymentStatus(payment.isPaymentStatus());
                        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
                        paymentDTO.setPaymentDate(payment.getPaymentDate());
                        paymentDTO.setCustomerId(payment.getCustomer().getCustomerId());
                        paymentDTO.setOrderId(payment.getOrder().getOrderId());
                        paymentDTO.setVendorId(payment.getVendor().getVendorId());
                        return paymentDTO;
                    }).collect(Collectors.toList());
            customerDTO.setPayments(paymentDTOS);


            return customerDTO;
        }).collect(Collectors.toList());
        ;

        return ResponseEntity.ok(customerDTOS);
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setCustomerId(customer.getCustomerId());
                    customerDTO.setUsername(customer.getUsername());
                    customerDTO.setPassword(customer.getPassword());
                    customerDTO.setEmail(customer.getEmail());
                    customerDTO.setAge(customer.getAge());
                    customerDTO.setSex(customer.getSex());

                    //list of shipping addresses owned by the customer
                    List<ShippingAddressDTO> shippingAddressDTOS = customer.getShippingAddresses().stream()
                            .map(shippingAddress -> {
                                ShippingAddressDTO shippingAddressDTO = new ShippingAddressDTO();
                                shippingAddressDTO.setShippingAddressId(shippingAddress.getShippindAdressId());
                                shippingAddressDTO.setStreet(shippingAddress.getStreet());
                                shippingAddressDTO.setCity(shippingAddress.getCity());
                                shippingAddressDTO.setCountry(shippingAddress.getCountry());
                                shippingAddressDTO.setPostalCode(shippingAddress.getPostalCode());
                                shippingAddressDTO.setState(shippingAddress.getState());
                                shippingAddressDTO.setPhoneNumber(shippingAddress.getPhoneNumber());
                                shippingAddressDTO.setCustomerId(shippingAddress.getCustomer().getCustomerId());
                                return shippingAddressDTO;
                            }).collect(Collectors.toList());
                    customerDTO.setShippingAddresses(shippingAddressDTOS);

                    //list of orders owned by the customer
                    List<OrderDTO> orderDTOS = customer.getOrders().stream()
                            .map(order -> {
                                OrderDTO orderDTO = new OrderDTO();
                                orderDTO.setOrderId(order.getOrderId());
                                orderDTO.setStatus(order.getStatus());
                                orderDTO.setTotalAmount(order.getTotalAmount());
                                orderDTO.setCustomerId(order.getCustomer().getCustomerId());
                                return orderDTO;
                            }).collect(Collectors.toList());
                    customerDTO.setOrders(orderDTOS);

                    //list of reviews written by the customer
                    List<ReviewDTO> reviewDTOS = customer.getReviews().stream()
                            .map(review -> {
                                ReviewDTO reviewDTO = new ReviewDTO();
                                reviewDTO.setRating(review.getRating());
                                reviewDTO.setComment(review.getComment());
                                reviewDTO.setProductId(review.getProduct().getProductId());
                                reviewDTO.setCustomerId(review.getCustomer().getCustomerId());
                                return reviewDTO;
                            }).collect(Collectors.toList());
                    customerDTO.setReviews(reviewDTOS);

                    //list of payments made by the customer
                    List<PaymentDTO> paymentDTOS = customer.getPayments().stream()
                            .map(payment -> {
                                PaymentDTO paymentDTO = new PaymentDTO();
                                paymentDTO.setPaymentDate(payment.getPaymentDate());
                                paymentDTO.setPaymentId(payment.getPaymentId());
                                paymentDTO.setAmount(payment.getAmount());
                                paymentDTO.setPaymentMethod(payment.getPaymentMethod());
                                paymentDTO.setPaymentStatus(payment.isPaymentStatus());
                                paymentDTO.setVendorId(payment.getVendor().getVendorId());
                                paymentDTO.setOrderId(payment.getOrder().getOrderId());
                                paymentDTO.setCustomerId(payment.getCustomer().getCustomerId());
                                return paymentDTO;
                            }).collect(Collectors.toList());
                    customerDTO.setPayments(paymentDTOS);

                    return ResponseEntity.ok(customerDTO);
                }).orElse(ResponseEntity.notFound().build());

    }

    // Get a customer by username
    @GetMapping("/username/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        Optional<Customer> customer = customerService.getCustomerByUsername(username);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing customera
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        try {
            Customer customer = customerService.updateCustomer(id, updatedCustomer);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a customer by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}


