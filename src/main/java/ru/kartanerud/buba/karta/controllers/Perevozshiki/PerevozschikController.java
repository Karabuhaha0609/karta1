package ru.kartanerud.buba.karta.controllers.Perevozshiki;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kartanerud.buba.karta.models.Karier;
import ru.kartanerud.buba.karta.models.Perevozhik;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.repo.PerevozchikRepo;
import ru.kartanerud.buba.karta.repo.VoditelRepo;
import ru.kartanerud.buba.karta.service.PerevozchikService;
import ru.kartanerud.buba.karta.service.VoditelService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/perevozchik")
public class PerevozschikController {

    @Autowired
    private final PerevozchikService perevozchikService;
    @Autowired
    private final VoditelService voditelService;
    @Autowired
    private final PerevozchikRepo perevozchikRepo;
    @Autowired
    private final VoditelRepo voditelRepo;

    @GetMapping
    public String homePerevozchik(Model model) {
        model.addAttribute("perevozchiks", perevozchikService.getPerevozhiks());
        return "perevozchiki/AllPerevozchik";
    }

    @GetMapping("/new")
    public String addPerevozchik(Model model) {
        model.addAttribute("perevozchik", new Perevozhik());
        return "/perevozchiki/NewPerevozchik";
    }

    @PostMapping("/new")
    public String addPerevozchik(@ModelAttribute Perevozhik perevozhik, Model model) {
        model.addAttribute(perevozchikService.addPerevozhik(perevozhik));
        return "redirect:/perevozchik";
    }

    @GetMapping("/{perevozhikId}")
    public String getPerevozchik(@PathVariable("perevozhikId") Long id, Model model) {
        model.addAttribute("perevozchik", perevozchikService.getPerevozhik(id));
        Optional<Perevozhik> thisPerevozchik = perevozchikService.getPerevozhik(id);

        return "/perevozchiki/HomePerevozchik";

    }

/*    @GetMapping("/{perevozhikId}/voditels")
    public String Voditeli(@PathVariable("perevozhikId") Long id,
            Model model) {
        model.addAttribute("voditeli", voditelService.getVoditelToPerevozchik(id));
        return "/perevozchiki/VoditelPage";
    }

    @GetMapping("/{perevozhikId}/voditels/new")
    public String newVoditelInfo(@PathVariable(value = "perevozhikId") Long id,
                                 @PathVariable("perevozhikId") Long perevozhikId,
                                 Model model) {
        model.addAttribute("perevozhik",perevozchikService.getPerevozhik(id));
        List<Voditel> voditelList = voditelRepo.findAllByPerevozhikId(perevozhikId);
        model.addAttribute("voditels",voditelList);
        Optional<Perevozhik> thisPerevozhik = perevozchikService.getPerevozhik(id);
        model.addAttribute("voditel", new Voditel());
        model.addAttribute("listPerevozchik",thisPerevozhik);
        return "perevozchiki/newVoditels_form";
    }

    @PostMapping("/voditels/save")
    public String saveVoditel(@ModelAttribute Voditel voditel, Model model) {
        *//*voditelService.addVoditel(voditel);*//*
        return "redirect:/perevozchik";
    }*/



}





