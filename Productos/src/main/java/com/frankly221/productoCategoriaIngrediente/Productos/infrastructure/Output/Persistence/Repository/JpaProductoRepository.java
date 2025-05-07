package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Entities.ProductoJpa;

import jakarta.transaction.Transactional;


@Repository

public interface JpaProductoRepository  extends JpaRepository<ProductoJpa, Integer> {

    // El restaurante puede actualizar solo sus propios productos.
    Optional<ProductoJpa> findByIdProductoAndIdRestaurante(int idProducto, int idRestaurante);

    // Un cliente puede ver los productos de un restaurante específico.
    List<ProductoJpa> findByIdRestaurante(int idRestaurante);

    @Transactional
     // El restaurante puede borrar un producto que ya no ofrece.
    void deleteByIdProductoAndIdRestaurante(int idProducto, int idRestaurante);

        // Un cliente puede ver los productos de un restaurante específico.
        List<ProductoJpa> findByIdCategoria(int idCategoria);
    
}
