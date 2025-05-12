package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoIngredienteDTO {

    
    private int idProductoIngrediente;


    private int idProducto;


    private int idIngrediente;

    private String nombreIngrediente;

    private String nombreProducto;

    private Instant creadoEn;

    private Instant actualizadoEn;

    private String sn;
  
    
}
