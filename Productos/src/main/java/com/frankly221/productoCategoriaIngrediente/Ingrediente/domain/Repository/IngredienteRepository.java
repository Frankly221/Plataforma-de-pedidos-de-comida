package com.frankly221.productoCategoriaIngrediente.Ingrediente.domain.Repository;

import java.util.List;

import com.frankly221.productoCategoriaIngrediente.Ingrediente.domain.Models.Ingrediente;

public interface IngredienteRepository {

    void saveIngrediente(Ingrediente ingrediente);
    Ingrediente findById(int idIngrediente);
    List<Ingrediente> findAll();
    void deleteById(Ingrediente ingrediente);
    void updateIngrediente(Ingrediente ingrediente);

    
}
