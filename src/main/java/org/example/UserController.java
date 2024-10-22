package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService; // Предполагается, что у вас есть репозиторий для работы с пользователями

    @GetMapping("/users")
    public String getUsers(Model model) {
        try {
            List<User> users = userService.findAll();
            model.addAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace(); // Печатает стек вызовов в логах
            model.addAttribute("errorMessage", "Ошибка получения данных: " + e.getMessage());
        }
        return "users";
    }
}