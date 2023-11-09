package com.cps714.webApp.controller;


import com.cps714.objects.users.Login;
import com.cps714.webApp.models.SessionUser;
import com.cps714.webApp.service.LoginService;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Data
@Controller
//@RequestMapping("/index")
@SessionAttributes({"sessionUser"})
public class LoginController {

    private LoginService loginService;

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/")
    public String get(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String login(Model model) {
        return "index";
    }


    @PostMapping("/submit")
    public String loginSubmit(Model model, Login login){
        System.out.println(login.toString());

        try{
            SessionUser user = loginService.doLogin(login);

            if(user == null){
                model.addAttribute("error", "Login failed");
                return "login";
            }

        }catch (Exception e){

        }
        return "login";
    }
}
