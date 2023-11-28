package com.cps714.webApp.controller;

import com.cps714.objects.users.Account;
import com.cps714.objects.users.Customer;
import com.cps714.repository.AccountRepository;
import com.cps714.repository.CustomerRepository;
import com.cps714.webApp.models.SessionUser;
import com.cps714.webApp.service.LoginService;
import com.cps714.webApp.service.RegisterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Controller for Register page
@Data
@Controller
//@RequestMapping("/register")
//Defining the session user that is used in all files
@SessionAttributes({"sessionUser"})
public class RegisterController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    //Method to get sessionUser
    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @Autowired
    private RegisterService registerService;

    //Mapping Register page using thymeleaf syntax
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    //Method to invoke signup logic
    @PostMapping("/signup")
    public String signup(Model model, Customer customer){
        //Saving the customer registration information in to the database
        customerRepository.save(customer);

        //Creating and storing account for Customer
        Account account = new Account();
        account.setEmail(customer.getEmail());
        account.setPassword(customer.getPassword());
        account.setCustomer(customer);
        accountRepository.save(account);

        //Defining the session user using customer registration information
        SessionUser user = registerService.doRegister(customer);
        model.addAttribute("sessionUser", user);

        return "redirect:landing";
    }
}
