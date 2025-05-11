package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.Mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO.IngredientesDTO;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO.ProductoIngredienteDTO;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO.ProductoIngredienteListDTO;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;

@Component

public class MapperSalidaData {

    
    private final ModelMapper modelMapper;

    
    public MapperSalidaData(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
         // Configurar para ignorar campos null al mapear
         this.modelMapper.getConfiguration()
         .setFieldMatchingEnabled(true)
         .setFieldAccessLevel(AccessLevel.PRIVATE)
         .setSkipNullEnabled(true);

        
    }
    
    public  ProductoIngredienteListDTO mapToDTO(List<ProductoIngrediente> productoIngrediente){


            ProductoIngredienteListDTO dto = new ProductoIngredienteListDTO();
            dto.setIdProducto(productoIngrediente.get(0).getIdProducto());
            dto.setNombreProducto(productoIngrediente.get(0).getNombreProducto());

                List<IngredientesDTO> ingredientes = productoIngrediente.stream()
            .map(pi -> new IngredientesDTO(pi.getIdIngrediente(), pi.getNombreIngrediente(), pi.getIdProductoIngrediente()))
            .toList();
        
             dto.setIngredientesAndIdProductoIngrediente(ingredientes);

        return dto;
    }

    public  ProductoIngredienteDTO ProductoIngredienteToProductoIngredienteDTO(ProductoIngrediente productoIngrediente) {

        ProductoIngredienteDTO dto = modelMapper.map(productoIngrediente, ProductoIngredienteDTO.class);
        return dto;


    }

         public  ProductoIngrediente ProductoIngredienteToDTOProductoIngrediente(ProductoIngredienteDTO dto) {

        ProductoIngrediente productoIngrediente = modelMapper.map(dto, ProductoIngrediente.class);
        return productoIngrediente;


    }   

         public  void actualizarProductoIngredienteDesdeDTO(ProductoIngredienteDTO dto, ProductoIngrediente productoIngredienteExistente) {

        modelMapper.map(dto, productoIngredienteExistente);


    }
    
    
    


}
