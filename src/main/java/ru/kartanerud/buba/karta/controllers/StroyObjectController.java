package ru.kartanerud.buba.karta.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.StroiObject;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.service.PerevozchikService;
import ru.kartanerud.buba.karta.service.StroiObjectService;
import ru.kartanerud.buba.karta.service.VoditelService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stroiObject")
public class StroyObjectController {

    @Autowired
    private final StroiObjectService stroiObjectService;

    @GetMapping
    public String allVoditelsToUser(Model model, Principal principal){
        Long users = stroiObjectService.getUserByPrincipal(principal).getId();
        List<StroiObject> stroiObjects = stroiObjectService.getStroiObjectsByUser(users);
        model.addAttribute("allStroiObjects", stroiObjects);
        return "stroiObjectsPage";
    }
    @GetMapping("/new")
    public String newStroiObject(Model model, Principal principal){
        model.addAttribute("stroiObject", new StroiObject(principal));
        return "newStroiObjects_form";
    }

    @PostMapping("/save")
    public String addStroiObject(StroiObject stroiObject, Principal principal) throws IOException {
        stroiObjectService.addStroiObject(principal, stroiObject);
        return "redirect:/stroiObject";
    }

    @GetMapping("/{id}")
    public String createStroyObject(Model model, Principal principal){
        model.addAttribute("allStroyObject", stroiObjectService.getAllStroiObjects());
        return "stroiObjectById";
    }
}
