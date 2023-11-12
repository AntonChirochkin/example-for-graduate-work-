package com.example.exampleforgraduatework.service;

import com.example.exampleforgraduatework.dto.Register;
/**
 * Интерфейс со способами входа в систему и регистрации пользователей.
 */
public interface AuthService {
    boolean login(String userName, String password);

    boolean register(Register register);
}
