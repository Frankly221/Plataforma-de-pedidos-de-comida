package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class IngredientesDTO {

    private int idIngrediente;
    private String nombre_ingrediente;
    private int idProductoIngrediente;

    
}
