package com.frankly221.productoCategoriaIngrediente.Productos.application.error.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;
    
}
