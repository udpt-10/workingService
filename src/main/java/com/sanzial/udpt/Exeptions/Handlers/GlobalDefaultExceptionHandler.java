package com.sanzial.udpt.Exeptions.Handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sanzial.udpt.Exeptions.BadRequestExeption;
import com.sanzial.udpt.Exeptions.ErrorInfo;
import com.sanzial.udpt.Exeptions.NotFoundExeption;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(NotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo handleNotFoundExeption(NotFoundExeption ex) {
        return new ErrorInfo(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestExeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleBadRequestExeption(BadRequestExeption ex) {
        return new ErrorInfo(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
