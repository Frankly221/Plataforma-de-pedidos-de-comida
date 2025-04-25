package com.frankly221.productoCategoriaIngrediente.Productos.application.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.frankly221.productoCategoriaIngrediente.Productos.application.error.dto.ErrorMessage;



@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> localNotFoundException(ProductoNotFoundException execption){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, execption.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    
    
}
