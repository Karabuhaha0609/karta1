package ru.kartanerud.buba.karta.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.enamy.scheben.*;
import ru.kartanerud.buba.karta.service.FilterService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeSchebenController {

        private final FilterService filterService;


    @GetMapping
    public String home(Model model /*, @ModelAttribute Frakcia frakcia */){
        //var listSchebensForFilter = Frakcia.values();
        List<Scheben> schebens = filterService.findAll();
        //List<Scheben> ooooo = listSchebensForFilter.stream().filter(n -> n.getFrakcia().equals(schebens)).collect(Collectors.toList());
        model.addAttribute("scheben", new Scheben());
        model.addAttribute("frakciashebensEnum", Frakcia.values());
        model.addAttribute("vidSchebensEnum", VidScheben.values());
        model.addAttribute("markaProchnostiEnum", MarkaProchnosti.values());
        model.addAttribute("radioaktivnostEnum", Radioaktivnost.values());
        model.addAttribute("gostEnum", Gost.values());
        model.addAttribute("leshadnostEnum", Leshadnost.values());
        model.addAttribute("markaPoIsteraemostiEnum", MarkaPoIsteraemosti.values());
        model.addAttribute("morozostoikostEnum", Morozostoikost.values());
        model.addAttribute("schebens", schebens);

        return "home/homeScheben";
    }


    @GetMapping("/filter")
    public String filter(Scheben scheben, Model model){
        List<Scheben> schebens = filterService.filterFrakcia(scheben.getFrakcia());
        List<Scheben> schebens1 = filterService.filterMarkaProchnosti(scheben.getMarkaProchnosti());
        List<Scheben> schebens2 = filterService.filterVidScheben(scheben.getVidScheben());
        List<Scheben> schebens3 = filterService.filterRadioaktivnost(scheben.getRadioaktivnost());
        List<Scheben> schebens4 = filterService.filterLeshadnost(scheben.getLeshadnost());
        List<Scheben> schebens5 = filterService.filterMarkaPoIsteraemosti(scheben.getMarkaPoIsteraemosti());
        List<Scheben> schebens6 = filterService.filterMorozostoikost(scheben.getMorozostoikost());
       List<Scheben> sc = new ArrayList<Scheben>();
        sc.addAll(schebens);
        sc.addAll(schebens1);
        sc.addAll(schebens2);
        sc.addAll(schebens3);
        sc.addAll(schebens4);
        sc.addAll(schebens5);
        sc.addAll(schebens6);
        List<Scheben> sc1 = sc.stream()
                .distinct()
        //        .filter(n -> n.getFrakcia().equals(scheben))
                .collect(Collectors.toList());

        model.addAttribute("schebens", sc1);
        model.addAttribute("scheben", new Scheben());
        model.addAttribute("frakciashebensEnum", Frakcia.values());
        model.addAttribute("vidSchebensEnum", VidScheben.values());
        model.addAttribute("markaProchnostiEnum", MarkaProchnosti.values());
        model.addAttribute("radioaktivnostEnum", Radioaktivnost.values());
        model.addAttribute("gostEnum", Gost.values());
        model.addAttribute("leshadnostEnum", Leshadnost.values());
        model.addAttribute("markaPoIsteraemostiEnum", MarkaPoIsteraemosti.values());
        model.addAttribute("morozostoikostEnum", Morozostoikost.values());


        return "home/homeScheben";
    }

}
