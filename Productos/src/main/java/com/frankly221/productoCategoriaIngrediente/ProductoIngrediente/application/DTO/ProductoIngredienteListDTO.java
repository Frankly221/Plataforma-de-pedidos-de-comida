package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ProductoIngredienteListDTO {


    private int idProducto;
    
    private String nombreProducto;

    private List<IngredientesDTO> ingredientesAndIdProductoIngrediente;
  
}
