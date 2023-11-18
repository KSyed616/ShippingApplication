package com.cps714.webApp.controller;

import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@Data
@Controller
@SessionAttributes({"sessionUser"})
public class AboutController {

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/aboutUs")
    public String about(Model model) {
        return "aboutUs";
    }
}
