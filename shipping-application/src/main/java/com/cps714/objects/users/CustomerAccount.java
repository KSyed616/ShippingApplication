package com.cps714.objects.users;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "CustomerAccount")
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer accountID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "DeliveryAddress")
    private String deliveryAddress;
}
