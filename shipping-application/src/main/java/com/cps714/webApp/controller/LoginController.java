package com.cps714.webApp.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class LoginController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
