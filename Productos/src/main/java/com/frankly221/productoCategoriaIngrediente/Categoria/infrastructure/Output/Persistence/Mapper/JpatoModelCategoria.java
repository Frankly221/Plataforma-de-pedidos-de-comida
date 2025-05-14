package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.Categoria.domain.Categoria;
import com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Entities.CategoriaJpa;

@Component

public class JpatoModelCategoria {

            // Inyección de dependencia de ModelMapper
        private final ModelMapper modelMapper;

    
    public JpatoModelCategoria(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);
    }

    public Categoria CategoriaJpaToModel(CategoriaJpa categoriaJpa) {
        return modelMapper.map(categoriaJpa, Categoria.class);
    }

    public CategoriaJpa CategoriaModelToJpa(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaJpa.class);
    }


    
}
