package com.cps714.repository;

import com.cps714.objects.users.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Repository file to access Customer Table
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //Method to find Customer using CustomerID
    Customer findByCustomerID(Integer customerID);

    //Method to find Customer using EmailID
    Customer findByEmail(String customerEmail);

    //Method to update Customer email
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE customers SET Email = ? WHERE CustomerID = ?")
    void setCustomerEmailByCustomerID(String email, Integer customerID);

    //Method to update customer password
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE customers SET Password = ? WHERE CustomerID = ?")
    void setCustomerPasswordByCustomerID(String password, Integer customerID);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE customers SET Phone = ? WHERE CustomerID = ?")
    void setCustomerPhoneByCustomerID(String phone, Integer customerID);

}