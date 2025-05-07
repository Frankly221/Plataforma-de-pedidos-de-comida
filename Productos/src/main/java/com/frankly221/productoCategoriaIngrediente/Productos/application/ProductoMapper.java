package com.frankly221.productoCategoriaIngrediente.Productos.application;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.Models.Producto;

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

    public ProductoDTO productoToProductoDTO(Producto producto){


       ProductoDTO productoDTO = modelMapper.map(producto,ProductoDTO.class);

        return productoDTO;
    }

    public Producto productoDTOToProducto(ProductoDTO productoDTO){
        Producto producto = modelMapper.map(productoDTO, Producto.class);

        return producto;
    }

    public void actualizarProductoDesdeDTO(ProductoDTO productoDTO, Producto productoExistente) {
        modelMapper.map(productoDTO, productoExistente);
    }



    
}
