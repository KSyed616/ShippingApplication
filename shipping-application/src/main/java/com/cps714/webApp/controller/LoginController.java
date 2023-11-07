package com.cps714.webApp.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Data
@Controller
public class LoginController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/submit")
    public String loginSubmit(Model model){
        return "submit";
    }
}
