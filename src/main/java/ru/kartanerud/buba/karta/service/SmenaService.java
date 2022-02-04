package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.Smena;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.repo.SmenaRepo;
import ru.kartanerud.buba.karta.repo.UserRepo;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SmenaService {

    @Autowired
    private final SmenaRepo smenaRepo;
    @Autowired
    private final UserRepo userRepo;

    public List<Smena> getAllSmens() {
        return smenaRepo.findAll();
    }

    @Transactional
    public Smena addSmena(Principal principal, Smena smena) {
        smena.setUser(getUserByPrincipal(principal));
        return smenaRepo.save(smena);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

    public Optional<Smena> getSmenaById(Long id) {
        return smenaRepo.findById(id);
    }

    public List<Smena> getSmenaByUser(Long id) {
        List<Smena> smenas = new ArrayList<>();

        smenaRepo.findByUserId(id)
                .forEach(smenas::add);

        return smenas;
    }

    public  List<LocalDate> getDatesBetween (
            LocalDate startDate, LocalDate endDate) {

        return startDate.datesUntil(endDate)
                .collect(Collectors.toList());
    }
}
