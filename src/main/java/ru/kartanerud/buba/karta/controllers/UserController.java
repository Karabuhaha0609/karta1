package ru.kartanerud.buba.karta.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.service.UserService;


@Slf4j
    @Controller
    @RequestMapping("/register")
    public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        // GET метод для отображения формы создания нового пользователя
        @GetMapping()
        public String showNewUserForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        @PostMapping("/new")
            public String addNewUser(@ModelAttribute("user") User user, Model model) {
                userService.save(user);
                    return "redirect:/login";

        }



    }

