package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frankly221.productoCategoriaIngrediente.Categoria.domain.Categoria;

public interface JpaCategoriaRepository extends JpaRepository<Categoria, Integer> {

    
}
