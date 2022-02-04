package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.Reis;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.repo.ReisRepo;
import ru.kartanerud.buba.karta.repo.UserRepo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReisService {

    @Autowired
    private ReisRepo reisRepo;
    @Autowired
    private final UserRepo userRepo;

    public List<Reis> getAllReises() {
        return reisRepo.findAll();
    }

    public Reis addReis(Principal principal, Reis reis) {
        reis.setUser(getUserByPrincipal(principal));
        return reisRepo.save(reis);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

    public Optional<Reis> getReisById(Long id) {
        return reisRepo.findById(id);
    }

    public List<Reis> getReisesByUser(Long id) {
        List<Reis> reises = new ArrayList<>();

        reisRepo.findByUserId(id)
                .forEach(reises::add);

        return reises;
    }
}
