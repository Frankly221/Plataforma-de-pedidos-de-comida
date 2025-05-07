package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ProductoIngredienteDTOQuery {






    private int idProducto;
    
    private String nombreProducto;
    
    private int idIngrediente;

    private String nombreIngrediente;



    
}
