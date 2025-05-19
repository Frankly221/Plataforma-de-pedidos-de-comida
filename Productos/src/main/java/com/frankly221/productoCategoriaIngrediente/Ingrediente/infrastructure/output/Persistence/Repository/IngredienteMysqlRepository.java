package com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Repository;

import java.util.List;

import com.frankly221.productoCategoriaIngrediente.Ingrediente.domain.Models.Ingrediente;
import com.frankly221.productoCategoriaIngrediente.Ingrediente.domain.Repository.IngredienteRepository;
import com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Entities.IngredienteJpa;
import com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Mapper.IngredientesMapper;


public class  IngredienteMysqlRepository implements IngredienteRepository {

    private final IngredienteJpaRepository jpaIngredienteRepository;
    private final IngredientesMapper mapper;

    public IngredienteMysqlRepository(IngredienteJpaRepository jpaIngredienteRepository, IngredientesMapper mapper) {
        this.jpaIngredienteRepository = jpaIngredienteRepository;
        this.mapper = mapper;
    }


    @Override
    public void saveIngrediente(Ingrediente ingrediente) {

        IngredienteJpa ingredienteJpa = mapper.modelToJpa(ingrediente);

        jpaIngredienteRepository.save(ingredienteJpa);

    }

    @Override
    public Ingrediente findById(int idIngrediente) {
        IngredienteJpa ingredienteJpa = jpaIngredienteRepository.findById(idIngrediente).orElse(null);

        
        Ingrediente ingrediente = mapper.JpaToModel(ingredienteJpa);

        return ingrediente;
    }

    @Override
    public List<Ingrediente> findAll() {

        List<IngredienteJpa> ingredientesJpa = jpaIngredienteRepository.findAll();

        List<Ingrediente> ingredientes = ingredientesJpa.stream()
                .map(mapper::JpaToModel)
                .toList();

        return ingredientes;


    }

    @Override
    public void deleteById(Ingrediente ingrediente) {

        IngredienteJpa ingredienteJpa = mapper.modelToJpa(ingrediente);

        jpaIngredienteRepository.save(ingredienteJpa);


    }

    @Override
    public void updateIngrediente(Ingrediente ingrediente) {

        IngredienteJpa ingredienteJpa = mapper.modelToJpa(ingrediente);

        jpaIngredienteRepository.save(ingredienteJpa);
    }
    
}
