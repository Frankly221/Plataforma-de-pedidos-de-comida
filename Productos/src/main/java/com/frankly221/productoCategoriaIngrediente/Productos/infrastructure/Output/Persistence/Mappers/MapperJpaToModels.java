package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.Models.Producto;
import com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Entities.ProductoJpa;
@Component
public class MapperJpaToModels {
    // Inyección de dependencia de ModelMapper
        private final ModelMapper modelMapper;

    
    public  MapperJpaToModels(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
         // Configurar para ignorar campos null al mapear
         this.modelMapper.getConfiguration()
         .setFieldMatchingEnabled(true)
         .setFieldAccessLevel(AccessLevel.PRIVATE)
         .setSkipNullEnabled(true);

        
    }

    public Producto productoJpaToProducto(ProductoJpa productoJpa){


       Producto producto = modelMapper.map(productoJpa,Producto.class);

        return producto;
    }

    public ProductoJpa productoToProductoJpa(Producto producto){
        ProductoJpa productoJpa = modelMapper.map(producto, ProductoJpa.class);

        return productoJpa;
    }

    // public void actualizarProductoDesdeDTO(ProductoDTO productoDTO, Producto productoExistente) {
    //     modelMapper.map(productoDTO, productoExistente);
    // }



    
    
}
