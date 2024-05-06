package com.mongoproject.compassmongo.controllers.exceptions;

import com.mongoproject.compassmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não encontrado", exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
