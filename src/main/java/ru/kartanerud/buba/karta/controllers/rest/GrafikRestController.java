package ru.kartanerud.buba.karta.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kartanerud.buba.karta.models.Grafik;
import ru.kartanerud.buba.karta.repo.GrafikRepo;

@RestController
@RequestMapping("/index/api/grafik")
public class GrafikRestController extends AbstractRestController<Grafik, GrafikRepo>{
    public GrafikRestController(GrafikRepo repo) {
        super(repo);
    }
}
