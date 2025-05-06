package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

import java.util.List;

public interface RepositoryProductoIngrediente {

    //Guardar en la tabla tantos productos como ingredientes se le pasen
    ProductoIngrediente save( List<ProductoIngrediente> productoIngrediente );

    //Busca por un producto y devuelve todos los ingredientes que tiene ese producto
    List<ProductoIngrediente> buscarIngredientesPorProducto(int idProducto); 


    //Edita la fila de la tabla segun el idProductoIngrediente que se le pase
    ProductoIngrediente update( List<ProductoIngrediente> productoIngrediente, int idProductoIngrediente); 


    //Elimina la fila de la tabla segun el idProductoIngrediente que se le pase , solo seria true or false
    void deleteByIdProductoAndIdrestaurante(ProductoIngrediente productoIngrediente, int idProductoIngrediente);

    
}
