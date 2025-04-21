package com.frankly221.Productos.application;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.frankly221.Productos.domain.Producto;

@Component
public class ProductoMapper {

    private final ModelMapper modelMapper;

    
    public ProductoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductoDTO productoToProductoDTO(Producto producto){


       ProductoDTO productoDTO = modelMapper.map(producto,ProductoDTO.class);

        return productoDTO;
    }

    public Producto productoDTOToProducto(ProductoDTO productoDTO){
        Producto producto = modelMapper.map(productoDTO, Producto.class);

        return producto;
    }



    
}
