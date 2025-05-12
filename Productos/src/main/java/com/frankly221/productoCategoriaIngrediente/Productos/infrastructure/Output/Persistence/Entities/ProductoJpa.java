package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "producto")
public class ProductoJpa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "disponible")
    private Boolean disponible;
    @Column(name = "id_restaurante")
    private int idRestaurante; // Relación con el restaurante (simplificada)
    @Column(name = "creado_en")
    private Instant creadoEn;
    @Column(name = "actualizado_en")
    private Instant actualizadoEn;

    @Column(name = "id_categoria")
    private int idCategoria; 
    
    @Column(name = "sn")
    private String sn; // Activo o no -> si - no

    
}