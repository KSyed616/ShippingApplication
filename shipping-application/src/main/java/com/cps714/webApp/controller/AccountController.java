package com.cps714.webApp.controller;

import com.cps714.objects.users.Customer;
import com.cps714.repository.CustomerRepository;
import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Data
@Controller
@SessionAttributes({"sessionUser"})
public class AccountController {

    @Autowired
    CustomerRepository customerRepository;

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/account")
    public String register(Model model, SessionUser user) {

        model.addAttribute("user", customerRepository.findByEmail(user.getEmail()));
        model.addAttribute("sessionUser", user);
        return "account";
    }

}
