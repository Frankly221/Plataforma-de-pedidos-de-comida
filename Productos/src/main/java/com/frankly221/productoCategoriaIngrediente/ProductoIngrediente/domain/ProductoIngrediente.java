package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

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

    
}
