package com.cps714.objects.users;

import lombok.Data;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Data
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "IsBusinessAccount")
    private Boolean isBusinessAccount;

    @Column(name = "BusinessName")
    private String businessName;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "ShippingAddress")
    private String shippingAddress;
}


