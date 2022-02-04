package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.models.Voditel;
import ru.kartanerud.buba.karta.repo.UserRepo;
import ru.kartanerud.buba.karta.repo.VoditelRepo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoditelService {

    @Autowired
    private final VoditelRepo voditelRepo;
    @Autowired
    private final UserRepo userRepo;

    public List<Voditel> getAllVoditels() {
        return voditelRepo.findAll();
    }

    public Voditel addVoditel(Principal principal, Voditel voditel) {
        voditel.setUser(getUserByPrincipal(principal));
        return voditelRepo.save(voditel);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

    public Optional<Voditel> getVoditelById(Long id) {
        return voditelRepo.findById(id);
    }

    public List<Voditel> getVoditelsByUser(Long id) {
        List<Voditel> voditels = new ArrayList<>();

        voditelRepo.findByUserId(id)
                .forEach(voditels::add);

        return voditels;
    }
}
