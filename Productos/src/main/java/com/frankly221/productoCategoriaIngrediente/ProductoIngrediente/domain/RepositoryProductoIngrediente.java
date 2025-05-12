package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

import java.util.List;

public interface RepositoryProductoIngrediente {

    //Busca por un producto y devuelve todos los ingredientes que tiene ese producto
    List<ProductoIngrediente> buscarIngredientesPorProducto(int idProducto); 

    //Guardar en la tabla tantos productos como ingredientes se le pasen
    void save( List<ProductoIngrediente> productoIngrediente );


    //Edita la fila de la tabla segun el idProductoIngrediente que se le pase
    void update( List<ProductoIngrediente> productoIngrediente);
    
    void updateone( ProductoIngrediente productoIngrediente);


    //Elimina la fila de la tabla segun el idProductoIngrediente que se le pase , solo seria true or false
    void deleteByIdProductoIngrediente(ProductoIngrediente productoIngrediente, int idProductoIngrediente);

    //Buscar por idProductoIngrediente
    ProductoIngrediente findByIdProductoIngrediente(int idProductoIngrediente);

    
}
