package ru.kartanerud.buba.karta.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.service.OrderService;

@Controller
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @GetMapping
    public String OrdersPage(){
        return "orderPage";
    }
}
