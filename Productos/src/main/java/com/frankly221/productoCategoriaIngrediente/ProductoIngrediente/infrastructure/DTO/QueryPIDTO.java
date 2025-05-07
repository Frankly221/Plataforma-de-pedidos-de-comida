package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class QueryPIDTO {

    
    private int idProducto;
    
    private String nombreProducto;
    
    private int idIngrediente;

    private String nombreIngrediente;
    
}
