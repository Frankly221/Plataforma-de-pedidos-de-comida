package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Entities.ProductoIngredienteJpa;

@Component

public class MapperProductoIngrediente {

        // Inyección de dependencia de ModelMapper
        private final ModelMapper modelMapper;

    
    public MapperProductoIngrediente(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);
    }

    public ProductoIngredienteJpa objectToEntitieJpa(Object[] object) {
        int idProducto = (object[0] instanceof Number) ? ((Number) object[0]).intValue() : 0;
        String nombreProducto = (String) object[1];
        int idIngrediente = (object[2] instanceof Number) ? ((Number) object[2]).intValue() : 0;
        String nombreIngrediente = (String) object[3];

        ProductoIngredienteJpa entity = new ProductoIngredienteJpa();
        entity.setIdProducto(idProducto);
        entity.setNombreProducto(nombreProducto);
        entity.setIdIngrediente(idIngrediente);
        entity.setNombreIngrediente(nombreIngrediente);

        return entity;
    }

    public ProductoIngrediente entityJpaToModel(ProductoIngredienteJpa entity) {
        return modelMapper.map(entity, ProductoIngrediente.class);
    }

    public ProductoIngredienteJpa modelToEntityJpa(ProductoIngrediente productoIngrediente) {
        ProductoIngredienteJpa entity = modelMapper.map(productoIngrediente, ProductoIngredienteJpa.class);

        return entity;
    }
    
}
