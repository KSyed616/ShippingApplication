package com.cps714.objects.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer accountID;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

}
