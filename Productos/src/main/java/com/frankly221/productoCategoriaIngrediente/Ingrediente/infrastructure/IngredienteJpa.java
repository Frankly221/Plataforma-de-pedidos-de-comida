package com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure;

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

@Data
@AllArgsConstructor
@Entity
@Table(name = "ingredientes")
@NoArgsConstructor

public class IngredienteJpa {

        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private int idIngrediente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "creado_en")
    private Instant creadoEn;
    
    @Column(name = "actualizado_en")
    private Instant actualizadoEn;

    @Column(name = "sn")
    private String sn;
    
}
