package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.Service;

import java.time.Instant;
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

    public ServiceProductoIngrediente(RepositoryProductoIngrediente productoIngredienteRepository,
            MapperSalidaData productoIngredienteMapper) {
        this.productoIngredienteRepository = productoIngredienteRepository;
        this.productoIngredienteMapper = productoIngredienteMapper;
    }

    // Busca por un producto y devuelve todos los ingredientes que tiene ese
    // producto
    public ProductoIngredienteListDTO findByIdProducto(int idProducto) {

        List<ProductoIngrediente> productoIngrediente = productoIngredienteRepository
                .buscarIngredientesPorProducto(idProducto);

        ProductoIngredienteListDTO dto = productoIngredienteMapper.mapToDTO(productoIngrediente);
        return dto;

    }

    public void save(List<ProductoIngrediente> productoIngredienteList) {
        Instant ahora = Instant.now();

        for (ProductoIngrediente pi : productoIngredienteList) {
            pi.setCreadoEn(ahora);
        }

        productoIngredienteRepository.save(productoIngredienteList); // Correcto: pasa la lista
    }

    public void update(List<ProductoIngrediente> productoIngredienteList) {

        Instant ahora = Instant.now();
        for (ProductoIngrediente pi : productoIngredienteList) {
            ProductoIngrediente piDataCompleta = productoIngredienteRepository
                    .findByIdProductoIngrediente(pi.getIdProductoIngrediente());

            if (piDataCompleta == null) {
                throw new RuntimeException(
                        "No se encontró el producto ingrediente con ID: " + pi.getIdProductoIngrediente());
            }

            if (pi.getIdProducto() != 0) {
                piDataCompleta.setIdProducto(pi.getIdProducto());
            }
            if (pi.getIdIngrediente() != 0) {
                piDataCompleta.setIdIngrediente(pi.getIdIngrediente());
            }

            piDataCompleta.setActualizadoEn(ahora);

            productoIngredienteRepository.updateone(piDataCompleta);

        }

    }

    public void deleteByIdProductoAndIdrestaurante( int idProductoIngrediente) {

        ProductoIngrediente piDataCompleta = productoIngredienteRepository
                .findByIdProductoIngrediente(idProductoIngrediente);

        if (piDataCompleta == null) {
            throw new RuntimeException(
                    "No se encontró el productoIngrediente con ID: " + idProductoIngrediente);
        }

        piDataCompleta.setSn("n");

        piDataCompleta.setActualizadoEn(Instant.now());
        productoIngredienteRepository.updateone(piDataCompleta);

        
    }

}
