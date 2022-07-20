package ru.kartanerud.buba.karta.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kartanerud.buba.karta.models.VoditelWeb;
import ru.kartanerud.buba.karta.repo.VoditelWebRepo;

@RestController
@RequestMapping("/index/api/voditelweb")
public class VoditelWebRestController extends AbstractRestController<VoditelWeb, VoditelWebRepo>{

    public VoditelWebRestController(VoditelWebRepo repo) {
        super(repo);
    }
}
