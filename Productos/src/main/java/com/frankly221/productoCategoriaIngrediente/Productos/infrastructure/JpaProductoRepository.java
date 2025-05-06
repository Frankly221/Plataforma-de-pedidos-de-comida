package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.ProductoIngrediente;

import jakarta.transaction.Transactional;


@Repository

public interface JpaProductoRepository  extends JpaRepository<ProductoIngrediente, Integer> {

    // El restaurante puede actualizar solo sus propios productos.
    Optional<ProductoIngrediente> findByIdProductoAndIdRestaurante(int idProducto, int idRestaurante);

    // Un cliente puede ver los productos de un restaurante específico.
    List<ProductoIngrediente> findByIdRestaurante(int idRestaurante);

    @Transactional
     // El restaurante puede borrar un producto que ya no ofrece.
    void deleteByIdProductoAndIdRestaurante(int idProducto, int idRestaurante);

        // Un cliente puede ver los productos de un restaurante específico.
        List<ProductoIngrediente> findByIdCategoria(int idCategoria);
    
}
