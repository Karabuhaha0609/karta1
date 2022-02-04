package ru.kartanerud.buba.karta.controllers.Perevozshiki;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.service.PerevozchikService;
import ru.kartanerud.buba.karta.service.VoditelService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("voditels")
public class VoditelController {

    @Autowired
    private final VoditelService voditelService;
    @Autowired
    private final PerevozchikService perevozchikService;

    @GetMapping
    public String allVoditelsToUser(Model model, Principal principal){
        Long users = voditelService.getUserByPrincipal(principal).getId();
        List<Voditel>voditels = voditelService.getVoditelsByUser(users);

        model.addAttribute("allVoditels", voditels);
        return "perevozchiki/voditelPage";
    }
    @GetMapping("/new")
    public String newVoditel(Model model, Principal principal){
        model.addAttribute("voditel", new Voditel(principal));
        return "perevozchiki/newVoditels_form";
    }

    @PostMapping("/save")
    public String addVoditel(Voditel voditel, Principal principal) throws IOException{
        voditelService.addVoditel(principal, voditel);
        return "redirect:/voditels";
    }

    @GetMapping("/{id}")
    public String createVoditel(Model model, Principal principal){
        model.addAttribute("allVoditels", voditelService.getAllVoditels());
        return "perevozchiki/AllVoditels";
    }

}


