package com.frankly221.productoCategoriaIngrediente.Categoria.application;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaDTO {

    private int idCategoria;

    private String nombre;

    private String descripcion;

    private Instant creadoEn;
    
    private Instant actualizadoEn;

    
}
