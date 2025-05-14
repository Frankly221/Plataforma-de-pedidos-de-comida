package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Entities.CategoriaJpa;

@Repository
public interface JpaCategoriaRepository extends JpaRepository<CategoriaJpa, Integer> {

    
}
