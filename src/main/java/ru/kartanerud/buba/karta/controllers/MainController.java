package ru.kartanerud.buba.karta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String Login(){
        return "login";
    }


    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
