package com.cps714.webApp.controller;

import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

//Controller for AboutUs HTML Page
@Data
@Controller
//Defining the session user that is used in all files
@SessionAttributes({"sessionUser"})
public class AboutController {

    //Method to get sessionUser
    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    //Method to display HTML page using Thymeleaf syntax
    @GetMapping("/aboutUs")
    public String about(Model model) {
        return "aboutUs";
    }
}
