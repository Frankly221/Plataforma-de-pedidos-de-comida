package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

import java.util.List;

public interface RepositoryProductoIngrediente {

    //Guardar en la tabla tantos productos como ingredientes se le pasen
    void save( List<ProductoIngrediente> productoIngrediente );


    //Edita la fila de la tabla segun el idProductoIngrediente que se le pase
    ProductoIngrediente update( List<ProductoIngrediente> productoIngrediente, int idProductoIngrediente); 


    //Elimina la fila de la tabla segun el idProductoIngrediente que se le pase , solo seria true or false
    void deleteByIdProductoAndIdrestaurante(ProductoIngrediente productoIngrediente, int idProductoIngrediente);

    
}
