package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

import java.util.List;
import java.util.Optional;

public interface RepositoryProductoIngrediente {

    ProductoIngrediente save( List<ProductoIngrediente> productoIngrediente );

    // El restaurante puede actualizar solo sus propios productos.
    Optional<ProductoIngrediente> findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante);

    // El restaurante puede actualizar solo sus propios productos.
    ProductoIngrediente update(ProductoIngrediente productoIngrediente); // Método para guardar los cambios

    // Un cliente puede ver los productos de un restaurante específico.
    List<ProductoIngrediente> findByIdrestaurante(int idRestaurante);

    // El restaurante puede borrar un producto que ya no ofrece.
    void deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante);

    // Un cliente puede ver los productos de una categoria en específico.
    List<ProductoIngrediente> findByIdCategoria(int idCategoria);
    
}
