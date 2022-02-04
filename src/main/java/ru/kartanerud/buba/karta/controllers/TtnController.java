package ru.kartanerud.buba.karta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ttn")
public class TtnController {

    @GetMapping
    public String ttnHome(){
        return "ttnPage";
    }
}
