package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kartanerud.buba.karta.models.*;
import ru.kartanerud.buba.karta.repo.OrderRepo;
import ru.kartanerud.buba.karta.repo.StroiObjectRepo;
import ru.kartanerud.buba.karta.repo.UserRepo;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepo orderRepo;
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final SchebenService schebenService;
    @Autowired
    private final StroiObjectRepo stroiObjectRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public Order saveOrder(Principal principal, Order order, Scheben scheben, StroiObject stroiObject){
        order.setUser(getUserByPrincipal(principal));
        order.setSchebens((List<Scheben>) schebenService.getScheben(scheben.getId()));
        order.setStroiObjects(getStroiObjectById(stroiObject, principal));
        orderRepo.save(order);
        return order;
    }

    private List<StroiObject> getStroiObjectById(StroiObject stroiObject, Principal principal) {
        return stroiObjectRepo.findAll((Sort) principal);
    }


    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

}
