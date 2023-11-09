package com.cps714.webApp.service;

import com.cps714.objects.users.Account;
import com.cps714.objects.users.Customer;
import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cps714.repository.CustomerRepository;

@Service
@Data   
public class LoginService {

    @Autowired
    private CustomerRepository repository;

    //Confirm the validity of login credentials
    public boolean checkLogin(Account account){
        try{
            Customer customer = repository.findByEmail(account.getEmail());
            if(customer == null){
                return false;
            }
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public SessionUser doLogin(Account account){
        try{
            Customer customer = repository.findByEmail(account.getEmail());
            if(customer == null){
                return null;
            }
            else{
                SessionUser user = new SessionUser();
                user.setEmail(customer.getEmail());
                user.setFirstName(customer.getFirstName());
                user.setLastName(customer.getLastName());
                user.setId(customer.getCustomerID());

                return user;
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
