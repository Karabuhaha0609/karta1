package ru.kartanerud.buba.karta.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kartanerud.buba.karta.models.Karier;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.enamy.scheben.*;
import ru.kartanerud.buba.karta.repo.KarierRepo;
import ru.kartanerud.buba.karta.repo.SchebenRepo;
import ru.kartanerud.buba.karta.service.SchebenService;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/schebens")
public class SchebenController {

    @Autowired
    private final SchebenRepo schebenRepo;
    @Autowired
    private final SchebenService schebenService;
    @Autowired
    private final KarierRepo karierRepo;

    @GetMapping("schebens")
    List<Scheben>AllScheben() {
        return schebenRepo.findAll();
    }

    @GetMapping("schebens/new")
    public String newSchebencreate(Model model){
        List<Karier>listkariers = karierRepo.findAll();
        model.addAttribute("scheben", new Scheben());
        model.addAttribute("listkariers", listkariers);
        model.addAttribute("gostShebensEnum", Gost.values());
        model.addAttribute("vidSchebenShebensEnum", VidScheben.values());
        model.addAttribute("frakciashebensEnum", Frakcia.values());
        model.addAttribute("leshadnostShebensEnum", Leshadnost.values());
        model.addAttribute("markaPoIsteraemostiShebensEnum", MarkaPoIsteraemosti.values());
        model.addAttribute("markaProchnostiShebensEnum", MarkaProchnosti.values());
        model.addAttribute("morozostoikostShebensEnum", Morozostoikost.values());
        model.addAttribute("radioaktivnostShebensEnum", Radioaktivnost.values());
        return "CreateScheben";
    }
    @PostMapping("/schebens/save")
    public String saveScheben(Scheben scheben) {
        schebenRepo.save(scheben);
        return "redirect:/kariers/";
    }

    @GetMapping("/schebens/{id}/edit")
    public String editScheben(Model model, @PathVariable("id") Long id){
        model.addAttribute("scheben", schebenService.getScheben(id));
        model.addAttribute("gostShebensEnum", Gost.values());
        model.addAttribute("vidSchebenShebensEnum", VidScheben.values());
        model.addAttribute("frakciashebensEnum", Frakcia.values());
        model.addAttribute("leshadnostShebensEnum", Leshadnost.values());
        model.addAttribute("markaPoIsteraemostiShebensEnum", MarkaPoIsteraemosti.values());
        model.addAttribute("markaProchnostiShebensEnum", MarkaProchnosti.values());
        model.addAttribute("morozostoikostShebensEnum", Morozostoikost.values());
        model.addAttribute("radioaktivnostShebensEnum", Radioaktivnost.values());
        return "scheben/EditScheben";
    }

    @PostMapping("/schebens/{id}/edit")
    public String editKarier(@PathVariable("id") Long id, @ModelAttribute("scheben") Scheben scheben) {
        schebenService.editScheben(id, scheben);
        return "redirect:/kariers";
    }

    @GetMapping("schebens/{id}/delete")
    public String deleteSchebenr(@PathVariable("id")Long id){
        schebenService.deleteScheben(id);
        return "redirect:/kariers";
    }
}
