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

//Controller for login
@Data
@Controller
//Defining the session user that is used in all files
@SessionAttributes({"sessionUser"})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    CustomerRepository customerRepository;

    //Method to get sessionUser
    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    //Method to map homepage to index using thymeleaf syntax
    @GetMapping("/")
    public String get(Model model) {
        return "index";
    }

    //Method to map /index using thymeleaf syntax
    @GetMapping("/index")
    public String login(Model model) {
        return "index";
    }

    //Method to invoke submit postMapping
    @PostMapping("/submit")
    public String loginSubmit(Model model, Account account){
        System.out.println(account.toString());
        SessionUser user = null;
        //Defining session user if the login information presented is correct
        if (loginService.checkLogin(account)) {
            user = loginService.doLogin(account);
        }
        //Checking if login succeeded, if not then user is redirected back to login page
        try{
            if(user == null){
                model.addAttribute("error", "Login failed");
                return "index";
            }
        }catch (Exception e){

        }
        //Defining session user if the login information presented is correct
        model.addAttribute("sessionUser",user);
        return "redirect:landing";
    }
}
