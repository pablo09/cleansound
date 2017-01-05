package com.pzeszko.cleansound.web.handler;

/**
 * Created by Pawel on 2017-01-05.
 */

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Model model, Exception ex) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/error";
    }
}
