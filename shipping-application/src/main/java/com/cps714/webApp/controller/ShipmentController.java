package com.cps714.webApp.controller;

import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Data
@Controller
@SessionAttributes({"sessionUser"})
public class ShipmentController {

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/shipment")
    public String shipment(Model model) {
        return "shipment";
    }
}
