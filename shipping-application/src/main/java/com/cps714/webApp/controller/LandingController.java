package com.cps714.webApp.controller;

import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//Controller for Landing page
@Data
@Controller
//Defining the session user that is used in all files
@SessionAttributes({"sessionUser"})
public class LandingController {

    //Defining the session user that is used in all files
    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    //Method to retrieve landing page using Thymeleaf syntax
    @GetMapping("/landing")
    public String landing(Model model) {
        return "landing";
    }

    //Method to retrieve shipment page using thymeleaf syntax
    @PostMapping("/shipment")
    public String shipment(Model model) {
        return "redirect:shipment";
    }

    //Method to retrieve the aboutUs page using thymeleaf syntax
    @PostMapping("/about")
    public String aboutUs(Model model) {
        return "redirect:aboutUs";
    }

    //Method to retrieve the account page using thymeleaf syntax
    @PostMapping("/account")
    public String account(Model model) {
        return "redirect:account";
    }
}
