package com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Entities.IngredienteJpa;

@Repository
public interface IngredienteRepository extends  JpaRepository<IngredienteJpa, Integer> {
    
}
