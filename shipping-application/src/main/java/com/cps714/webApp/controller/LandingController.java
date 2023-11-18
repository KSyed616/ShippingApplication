package com.cps714.webApp.controller;

import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Data
@Controller
@SessionAttributes({"sessionUser"})
public class LandingController {

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/landing")
    public String landing(Model model) {
        return "landing";
    }

    @PostMapping("/shipment")
    public String shipment(Model model) {
        return "redirect:shipment";
    }

    @PostMapping("/about")
    public String aboutUs(Model model) {
        return "redirect:aboutUs";
    }

    @PostMapping("/account")
    public String account(Model model) {
        return "redirect:account";
    }
}
