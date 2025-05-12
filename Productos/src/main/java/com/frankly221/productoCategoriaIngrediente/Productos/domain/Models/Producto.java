package com.frankly221.productoCategoriaIngrediente.Productos.domain.Models;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {


    private int idProducto;

    private String descripcion;

    private Double precio;

    private Boolean disponible;

    private int idRestaurante; // Relación con el restaurante (simplificada)

    private Instant creadoEn;

    private Instant actualizadoEn;

    private int idCategoria; 


    private String sn; // Activo o no -> si - no
    
}
