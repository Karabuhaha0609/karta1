package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.StroiObject;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.repo.StroiObjectRepo;
import ru.kartanerud.buba.karta.repo.UserRepo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StroiObjectService {

    @Autowired
    private final StroiObjectRepo stroiObjectRepo;
    @Autowired
    private final UserRepo userRepo;

    public List<StroiObject> getAllStroiObjects() {
        return stroiObjectRepo.findAll();
    }

    public StroiObject addStroiObject(Principal principal, StroiObject stroiObject) {
        stroiObject.setUser(getUserByPrincipal(principal));
        return stroiObjectRepo.save(stroiObject);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

    public Optional<StroiObject> getStroiObjectById(Long id) {
        return stroiObjectRepo.findById(id);
    }

    public List<StroiObject> getStroiObjectsByUser(Long id) {
        List<StroiObject> stroiObjects = new ArrayList<>();

        stroiObjectRepo.findByUserId(id)
                .forEach(stroiObjects::add);

        return stroiObjects;
    }
}
