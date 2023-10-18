package com.example.exampleforgraduatework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.exampleforgraduatework.exceptions.WrongCurrentPasswordException;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = {WrongCurrentPasswordException.class})
    public ResponseEntity<?> handleWrongPassword(WrongCurrentPasswordException exception) {
        String message = "Введен некорректный текущий пароль";
        return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
    }
}
