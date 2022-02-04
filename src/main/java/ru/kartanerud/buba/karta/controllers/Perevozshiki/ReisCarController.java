package ru.kartanerud.buba.karta.controllers.Perevozshiki;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.Reis;
import ru.kartanerud.buba.karta.service.ReisService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reises")
public class ReisCarController {

    @Autowired
    private final ReisService reisService;

    @GetMapping
    public String allReisesToUser(Model model, Principal principal){
        Long users = reisService.getUserByPrincipal(principal).getId();
        List<Reis> reises = reisService.getReisesByUser(users);
        model.addAttribute("allReises", reises);
        return "perevozchiki/reisPage";
    }
    @GetMapping("/new")
    public String newVoditel(Model model, Principal principal){
        model.addAttribute("reis", new Reis(principal));
        return "perevozchiki/newReis_form";
    }

    @PostMapping("/save")
    public String addReis(Reis reis, Principal principal) throws IOException {
        reisService.addReis(principal, reis);
        return "redirect:/reises";
    }

    @GetMapping("/{id}")
    public String createVoditel(Model model, Principal principal){
        model.addAttribute("allReises", reisService.getUserByPrincipal(principal));
        return "perevozchiki/AllVoditels";
    }

}
