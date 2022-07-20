package ru.kartanerud.buba.karta.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kartanerud.buba.karta.models.Model;
import ru.kartanerud.buba.karta.repo.ModelRepo;

@RestController
@RequestMapping("/index/api/model")
public class ModelController extends AbstractRestController<Model, ModelRepo>{

    public ModelController(ModelRepo repo) {
        super(repo);
    }
}
