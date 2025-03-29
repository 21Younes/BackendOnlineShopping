package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderId")
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private double totalAmount;
    private String status; // "PENDING", "SHIPPED", "DELIVERED"


    //relationship between the order and the customer
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer; // The customer who placed the order



    //relationship between the order and the order item
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> Items;


    //relationship between the order and the vendor
    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor vendor; // The vendor who will fulfill the order


}