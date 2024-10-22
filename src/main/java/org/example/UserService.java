package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Предполагаем, что у вас есть репозиторий

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        System.out.println("Полученные пользователи: " + users); // Логируем полученные пользователи
        return users;
    }
}