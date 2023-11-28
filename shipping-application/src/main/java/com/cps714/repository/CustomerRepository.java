package com.cps714.repository;

import com.cps714.objects.users.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerID(Integer customerID);

    Customer findByEmail(String customerEmail);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE customers SET Email = ?, Phone = ?, Password = ? WHERE CustomerID = ?")
    void setCustomerInformationByCustomerID(String email, String phone, String password, Integer customerID);

}