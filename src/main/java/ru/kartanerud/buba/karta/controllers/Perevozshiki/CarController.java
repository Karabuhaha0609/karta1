package ru.kartanerud.buba.karta.controllers.Perevozshiki;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.Car;
import ru.kartanerud.buba.karta.models.enamy.VidCar;
import ru.kartanerud.buba.karta.service.CarService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("cars")
public class CarController {

    @Autowired
    private final CarService carService;

    @GetMapping
    public String allCarsToUser(Model model, Principal principal){
        Long users = carService.getUserByPrincipal(principal).getId();
        List<Car> cars = carService.getCarsByUser(users);

        model.addAttribute("allCars", cars);
        return "/perevozchiki/cars/carsPage";
    }
    @GetMapping("/new")
    public String newCar(Model model, Principal principal){
        model.addAttribute("car", new Car(principal));
        model.addAttribute("vidCarEnum", VidCar.values());
        return "perevozchiki/cars/newCars_form";
    }

    @PostMapping("/save")
    public String addCar(Car car, Principal principal) throws IOException{
        carService.addCar(principal, car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String createVoditel(Model model, Principal principal){
        model.addAttribute("allVoditels", carService.getAllCars());
        return "perevozchiki/AllVoditels";
    }

}


