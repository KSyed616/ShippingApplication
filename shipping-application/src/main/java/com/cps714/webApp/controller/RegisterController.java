package com.cps714.webApp.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping()
    public String get(Model model) {
        return "register";
    }

}
