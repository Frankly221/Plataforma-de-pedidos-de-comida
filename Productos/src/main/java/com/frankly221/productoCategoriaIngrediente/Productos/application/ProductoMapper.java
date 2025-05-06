package com.frankly221.productoCategoriaIngrediente.Productos.application;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.ProductoIngrediente;

@Component
public class ProductoMapper {

    private final ModelMapper modelMapper;

    
    public ProductoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
         // Configurar para ignorar campos null al mapear
         this.modelMapper.getConfiguration()
         .setFieldMatchingEnabled(true)
         .setFieldAccessLevel(AccessLevel.PRIVATE)
         .setSkipNullEnabled(true);

        
    }

    public ProductoDTO productoToProductoDTO(ProductoIngrediente producto){


       ProductoDTO productoDTO = modelMapper.map(producto,ProductoDTO.class);

        return productoDTO;
    }

    public ProductoIngrediente productoDTOToProducto(ProductoDTO productoDTO){
        ProductoIngrediente producto = modelMapper.map(productoDTO, ProductoIngrediente.class);

        return producto;
    }

    public void actualizarProductoDesdeDTO(ProductoDTO productoDTO, ProductoIngrediente productoExistente) {
        modelMapper.map(productoDTO, productoExistente);
    }



    
}
