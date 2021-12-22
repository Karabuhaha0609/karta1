package ru.kartanerud.buba.karta.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.kartanerud.buba.karta.models.Karier;
import ru.kartanerud.buba.karta.models.Scheben;
import ru.kartanerud.buba.karta.models.enamy.karier.Oblast;
import ru.kartanerud.buba.karta.models.enamy.scheben.*;
import ru.kartanerud.buba.karta.repo.SchebenRepo;
import ru.kartanerud.buba.karta.service.KarierService;
import ru.kartanerud.buba.karta.service.SchebenService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/kariers")
public class KarierController {

    @Autowired
    private final KarierService karierService;
    @Autowired
    private final SchebenService schebenService;
    @Autowired
    private final SchebenRepo schebenRepo;


    @GetMapping()
    public String getKariers(Model model) {
        model.addAttribute("kariers", karierService.getKariers());

        return "AllKariers";
    }

    @GetMapping("/{id}")
    public String getKarier(@PathVariable("id") Long id,@PathVariable("id") Long karierId, Model model){
            model.addAttribute("karier", karierService.getKarier(id));
        List<Scheben> ListKarierId = schebenRepo.findAllByKarierId(karierId);
            model.addAttribute("schebens",ListKarierId);
            Karier  thisKarier = karierService.getKarier(id);
        model.addAttribute("scheben", new Scheben());
        model.addAttribute("listkariers", thisKarier);
        model.addAttribute("gostShebensEnum", Gost.values());
        model.addAttribute("vidSchebenShebensEnum", VidScheben.values());
        model.addAttribute("frakciashebensEnum", Frakcia.values());
        model.addAttribute("leshadnostShebensEnum", Leshadnost.values());
        model.addAttribute("markaPoIsteraemostiShebensEnum", MarkaPoIsteraemosti.values());
        model.addAttribute("markaProchnostiShebensEnum", MarkaProchnosti.values());
        model.addAttribute("morozostoikostShebensEnum", Morozostoikost.values());
        model.addAttribute("radioaktivnostShebensEnum", Radioaktivnost.values());

        return "OneKarierShow";
    }
    @PostMapping("/schebens/save")
    public String saveScheben(Scheben scheben){
        schebenRepo.save(scheben);
        return "redirect:/kariers";
    }

    @GetMapping("new")
    public String addKarier(Model model){
        model.addAttribute("karier",new Karier());
        model.addAttribute("oblasts", Oblast.values());
        return "newKarier";
    }

    @PostMapping("new")
    public String addKarier(@ModelAttribute Karier karier, Model model) {
//        if (errors.hasErrors()){
//            return "newKarier";
//        }
        model.addAttribute(karierService.addKarier(karier));

        return "redirect:/kariers";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("karier", karierService.getKarier(id));
        model.addAttribute("oblasts", Oblast.values());
        return "EditKarier";
    }

    @PostMapping(value = "{id}")
    public String editKarier(@PathVariable("id") Long id, @ModelAttribute("karier") Karier karier) {
    karierService.editKarier(id, karier);
    return "redirect:/kariers/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteKarier(@PathVariable("id")Long id){
    karierService.deleteKarier(id);
    return "redirect:/kariers";
    }

}
