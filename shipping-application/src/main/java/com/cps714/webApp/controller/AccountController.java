package com.cps714.webApp.controller;

import com.cps714.objects.users.Account;
import com.cps714.objects.users.Customer;
import com.cps714.repository.AccountRepository;
import com.cps714.repository.CustomerRepository;
import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Controller for Account HTML Page
@Data
@Controller
//Defining the session user that is used in all files
@SessionAttributes({"sessionUser"})
public class AccountController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    //Method to get sessionUser
    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    //Method to display HTML page using Thymeleaf syntax
    @GetMapping("/account")
    public String register(Model model, SessionUser user) {
        //Defing model attribute for Thymeleaf syntax to pickup and display on frontend
        model.addAttribute("user", customerRepository.findByEmail(user.getEmail()));
        //Defining session user attribute
        model.addAttribute("sessionUser", user);
        return "account";
    }

    //Method for changeAccount mapping
    @PostMapping("/changeAccount")
    public String changeAccount(Model model, Customer customer, SessionUser sessionUser) {
        //Defining new customer to hold the customer sent by Thymeleaf from frontend
        Customer customer2 = customerRepository.findByCustomerID(sessionUser.getId());

        //Changing the customer email in repository and sessionUser if necessary
        if(!customer.getEmail().isEmpty()) {
            customerRepository.setCustomerEmailByCustomerID(customer.getEmail(), customer2.getCustomerID());
            sessionUser.setEmail(customer.getEmail());
            accountRepository.setAccountEmailByCustomerID(customer.getEmail(), customer2.getCustomerID());
        }
        //Changing the customer password in repository and sessionUser if necessary
        if(!customer.getPassword().isEmpty()) {
            customerRepository.setCustomerPasswordByCustomerID(customer.getPassword(), customer2.getCustomerID());
            sessionUser.setEmail(customer2.getEmail());
            accountRepository.setAccountPasswordeByCustomerID(customer.getPassword(), customer2.getCustomerID());
        }
        //Changing the customer phone number in repository
        if(!customer.getPhone().isEmpty()) {
            customerRepository.setCustomerPhoneByCustomerID(customer.getPhone(), customer2.getCustomerID());
            sessionUser.setEmail(customer2.getEmail());
        }
        //Setting the password for the sessionUser as original password if not changed
        else{
            sessionUser.setEmail(customer2.getEmail());
        }

        //Defining models that thymeleaf will use to display the account information
        model.addAttribute("user", customerRepository.findById(sessionUser.getId()));
        model.addAttribute("sessionUser", sessionUser);
        return "redirect:/account";
    }

}
