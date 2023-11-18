package com.cps714.webApp.controller;


import com.cps714.objects.users.Account;
import com.cps714.repository.CustomerRepository;
import com.cps714.webApp.models.SessionUser;
import com.cps714.webApp.service.LoginService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Data
@Controller
@SessionAttributes({"sessionUser"})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    CustomerRepository customerRepository;

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
    public String loginSubmit(Model model, Account account){
        System.out.println(account.toString());
        SessionUser user = loginService.doLogin(account);

        try{

            if(user == null){
                model.addAttribute("error", "Login failed");
                return "login";
            }

        }catch (Exception e){

        }

        model.addAttribute("sessionUser",user);
        return "redirect:landing";
    }
}
