package ru.kartanerud.buba.karta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerevozschikController {


    @GetMapping("/perevozschik")
        public String homePerevozchik(){
            return "index";
        }
    }

