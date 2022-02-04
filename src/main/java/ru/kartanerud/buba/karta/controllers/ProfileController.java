package ru.kartanerud.buba.karta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.service.VoditelService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private final VoditelService voditelService;

    public ProfileController(VoditelService voditelService) {
        this.voditelService = voditelService;
    }

    @RequestMapping(value = "/profile")
    public String profile(Model model, Principal principal){
/*        Long un = Long.valueOf(principal.getName());
        model.addAttribute("voditel",voditelService.findByUserName(un));*/
        return "profile";
    }
}
