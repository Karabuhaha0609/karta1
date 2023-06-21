package ru.kartanerud.buba.karta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kartanerud.buba.karta.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String Login(){
        return "login";
    }


    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
