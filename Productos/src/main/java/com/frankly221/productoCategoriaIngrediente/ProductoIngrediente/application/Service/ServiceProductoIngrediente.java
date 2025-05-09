package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO.ProductoIngredienteListDTO;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.Mapper.MapperSalidaData;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.RepositoryProductoIngrediente;


@Service

public class ServiceProductoIngrediente {

    private final RepositoryProductoIngrediente productoIngredienteRepository;
    private final MapperSalidaData productoIngredienteMapper;

    public ServiceProductoIngrediente(RepositoryProductoIngrediente productoIngredienteRepository, MapperSalidaData productoIngredienteMapper) {
        this.productoIngredienteRepository = productoIngredienteRepository;
        this.productoIngredienteMapper = productoIngredienteMapper;
    }

    // Busca por un producto y devuelve todos los ingredientes que tiene ese producto
    public ProductoIngredienteListDTO findByIdProducto( int idProducto) {

        List<ProductoIngrediente> productoIngrediente = productoIngredienteRepository.buscarIngredientesPorProducto(idProducto);

        ProductoIngredienteListDTO dto = productoIngredienteMapper.mapToDTO(productoIngrediente);
        return dto;

    }

    
}
