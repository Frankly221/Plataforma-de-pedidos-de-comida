package com.frankly221.productoCategoriaIngrediente.Productos.domain.Repository;

import java.util.List;
import java.util.Optional;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.Models.Producto;

public interface ProductoRepository {
    // Un restaurante puede crear un producto (nombre, precio, descripción, etc.).
    // Se asume que el objeto Producto ya tiene el restauranteId asignado.
    Producto save(Producto producto);

    // El restaurante puede actualizar solo sus propios productos.
    Optional<Producto> findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante);

    // El restaurante puede actualizar solo sus propios productos.
    Producto update(Producto producto); // Método para guardar los cambios

    // Un cliente puede ver los productos de un restaurante específico.
    List<Producto> findByIdrestaurante(int idRestaurante);

    // El restaurante puede borrar un producto que ya no ofrece.
    void deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante);

    // Un cliente puede ver los productos de una categoria en específico.
    List<Producto> findByIdCategoria(int idCategoria);
}

