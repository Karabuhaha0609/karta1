package ru.kartanerud.buba.karta.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.Car;
import ru.kartanerud.buba.karta.models.Smena;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.service.CarService;
import ru.kartanerud.buba.karta.service.SmenaService;
import ru.kartanerud.buba.karta.service.VoditelService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("smena")
public class SmenaController {

    @Autowired
    private final VoditelService voditelService;
    @Autowired
    private final CarService carService;
    @Autowired
    private final SmenaService smenaService;

    @GetMapping
    public String allVoditelsToUser(Model model, Principal principal) {
        Long users = voditelService.getUserByPrincipal(principal).getId();
        List<Voditel> voditels = voditelService.getVoditelsByUser(users);
        List<Car> cars = carService.getCarsByUser(users);
        model.addAttribute("allCars", cars);
        model.addAttribute("allVoditels", voditels);
        return "smenaPage";
    }
    @GetMapping("/new")
    public String newVoditel(Model model, Principal principal){
        model.addAttribute("smena", new Smena(principal));
        Long users = voditelService.getUserByPrincipal(principal).getId();
        List<Voditel> voditels = voditelService.getVoditelsByUser(users);
        List<Car> cars = carService.getCarsByUser(users);
        List<Smena> smenas = smenaService.getSmenaByUser(users);
        model.addAttribute("allCars", cars);
        model.addAttribute("allVoditels", voditels);
        model.addAttribute("AllSmenas", smenas);
        return "newSmenas_form";
    }

    @PostMapping("/save")
    public String addSmena(Smena smena, Principal principal) throws IOException {
        smenaService.addSmena(principal, smena);

        return "redirect:/smena";
    }

    @GetMapping("/{id}")
    public String createVoditel(Model model, Principal principal){
        model.addAttribute("allSmenas", smenaService.getAllSmens());
        return "allSmena";
    }

}
