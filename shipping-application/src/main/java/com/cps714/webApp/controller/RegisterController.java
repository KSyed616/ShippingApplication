package com.cps714.webApp.controller;

import com.cps714.objects.users.Customer;
import com.cps714.repository.CustomerRepository;
import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
//@RequestMapping("/register")
@SessionAttributes({"sessionUser"})
public class RegisterController {

    @Autowired
    CustomerRepository customerRepository;

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/register")
    public String get(Model model) {
        return "register";
    }

    @PostMapping("/signup")
    public String signup(Model model, Customer customer){
        System.out.println(customer.toString());
        customerRepository.save(customer);
        return "account";
    }
}
