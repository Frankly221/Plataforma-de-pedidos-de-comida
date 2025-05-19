package com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

import com.frankly221.productoCategoriaIngrediente.Ingrediente.domain.Models.Ingrediente;
import com.frankly221.productoCategoriaIngrediente.Ingrediente.infrastructure.output.Persistence.Entities.IngredienteJpa;

public class IngredientesMapper {
            // Inyección de dependencia de ModelMapper
        private final ModelMapper modelMapper;

    
    public IngredientesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);
    }

    public Ingrediente JpaToModel(IngredienteJpa jpa){
        return modelMapper.map(jpa, Ingrediente.class);
    }

    public IngredienteJpa modelToJpa(Ingrediente ingrediente){
        return modelMapper.map(ingrediente, IngredienteJpa.class);
    }


    
}
