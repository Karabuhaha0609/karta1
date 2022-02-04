package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.Car;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.repo.CarRepo;
import ru.kartanerud.buba.karta.repo.UserRepo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    @Autowired
    private final CarRepo carRepo;
    @Autowired
    private final UserRepo userRepo;

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Car addCar(Principal principal, Car car) {
        car.setUser(getUserByPrincipal(principal));
        return carRepo.save(car);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

    public Optional<Car> getCarById(Long id) {
        return carRepo.findById(id);
    }

    public List<Car> getCarsByUser(Long id) {
        List<Car> cars = new ArrayList<>();

        carRepo.findByUserId(id)
                .forEach(cars::add);

        return cars;
    }
}

