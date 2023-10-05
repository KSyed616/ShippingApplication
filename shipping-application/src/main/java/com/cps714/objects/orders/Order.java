package com.cps714.objects.orders;

import com.cps714.objects.products.Product;
import com.cps714.objects.users.Customer;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @NotNull
    @Column(name = "order_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;

    @NotNull
    @Column(name = "order_date")
    private String orderDate;

    /*@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;*/

}
