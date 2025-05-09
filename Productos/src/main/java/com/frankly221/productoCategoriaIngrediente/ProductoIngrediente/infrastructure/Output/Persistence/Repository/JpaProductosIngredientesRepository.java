package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Entities.ProductoIngredienteJpa;


@Repository

public interface JpaProductosIngredientesRepository extends  JpaRepository<ProductoIngredienteJpa, Integer> {

    @Query(value = """
           SELECT
               p.id_producto       AS producto_id, 
               p.descripcion       AS producto_nombre,
               i.idingrediente     AS ingrediente_id,
               i.nombre            AS ingrediente_nombre
           FROM producto p
           JOIN producto_ingrediente pi ON p.id_producto = pi.id_producto
           JOIN ingrediente i          ON pi.id_ingrediente = i.idingrediente
           WHERE p.id_producto = :idProducto
           ORDER BY i.nombre
           """, nativeQuery = true)
    List<Object[]> findIngredientesByIdProducto(@Param("idProducto") int idProducto);
}
