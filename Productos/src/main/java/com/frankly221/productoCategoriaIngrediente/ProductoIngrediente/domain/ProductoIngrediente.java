package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoIngrediente {


    private int idProductoIngrediente;


    private int idProducto;


    private int idIngrediente;

    private String nombreIngrediente;

    private String nombreProducto;

    private Instant creadoEn;

    private Instant actualizadoEn;

    //Activo o no -> si - no
    private String sn;
    
}
