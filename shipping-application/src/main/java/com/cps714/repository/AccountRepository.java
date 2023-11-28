package com.cps714.repository;

import com.cps714.objects.users.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Repository file to access the Account table
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    //Method to retrieve account using AccountID
    Account findByAccountID(Integer accountID);

    //Method to retrieve account using CustomerID
    Account getAccountByCustomerCustomerID(Integer customerID);

    //Method to Update email for specified account
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE account SET Email = ? WHERE CustomerID = ?")
    void setAccountEmailByCustomerID(String email, Integer customerID);

    //Method to Update password for specified account
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE account SET Password = ? WHERE CustomerID = ?")
    void setAccountPasswordeByCustomerID(String phone, Integer customerID);

}