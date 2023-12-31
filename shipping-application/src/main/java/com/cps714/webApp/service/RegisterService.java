package com.cps714.webApp.service;

import com.cps714.objects.users.Customer;
import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.stereotype.Service;

//Service page for Register page
@Service
@Data
public class RegisterService {

    //Method that completes registration and defines the session user
    public SessionUser doRegister(Customer customer) {

        SessionUser user = new SessionUser();
        user.setEmail(customer.getEmail());
        user.setFirstName(customer.getFirstName());
        user.setLastName(customer.getLastName());
        user.setId(customer.getCustomerID());

        return user;
    }
}
