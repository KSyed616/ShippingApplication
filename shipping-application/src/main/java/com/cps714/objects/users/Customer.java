package com.cps714.objects.users;

import lombok.Data;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

//Entity file for Customers table
@Data
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "ShippingAddress")
    private String shippingAddress;
}


