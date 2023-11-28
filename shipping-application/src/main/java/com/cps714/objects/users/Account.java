package com.cps714.objects.users;

import jakarta.persistence.*;
import lombok.Data;

//Entity table for Account
@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer accountID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

}
