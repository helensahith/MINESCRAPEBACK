package com.example.minescrapeback.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserPassNotMatchAdvice {
    @ResponseBody
    @ExceptionHandler(UserPassNotMatchException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)

    String userIncorrectPassword(UserPassNotMatchException ex) {
        return ex.getMessage();
    }

}
