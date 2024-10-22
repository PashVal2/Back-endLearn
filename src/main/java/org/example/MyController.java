package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "I am Hitler");
        return "index";
    }
    @PostMapping("/newPage")
    public String newPage(@RequestParam(name = "name", required = false) String name, Model model) {
        if (name == null || name.isEmpty()) { // Проверка на null или пустую строку
            name = "Гость"; // Значение по умолчанию
        }
        model.addAttribute("message", "Hi, " + name + "!");
        return "newPage"; // Возвращает newPage.html из папки templates
    }
}
