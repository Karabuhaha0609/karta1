package ru.kartanerud.buba.karta.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kartanerud.buba.karta.models.Mark;
import ru.kartanerud.buba.karta.repo.MarkRepo;

@RestController
@RequestMapping("/index/api/mark")
public class MarkRestController extends AbstractRestController<Mark, MarkRepo> {
    public MarkRestController(MarkRepo repo) {
        super(repo);
    }
}
