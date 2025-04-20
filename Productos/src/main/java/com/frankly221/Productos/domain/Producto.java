package com.frankly221.Productos.domain;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "producto")
public class Producto {

    private int idProducto;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
    private int restauranteId; // Relación con el restaurante (simplificada)
    private Instant creadoEn;
    private Instant actualizadoEn;

    
}
