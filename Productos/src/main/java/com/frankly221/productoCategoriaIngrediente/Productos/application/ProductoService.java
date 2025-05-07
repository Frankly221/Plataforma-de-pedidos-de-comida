package com.frankly221.productoCategoriaIngrediente.Productos.application;

import java.time.Instant;
import java.util.List;


import org.springframework.stereotype.Service;

import com.frankly221.productoCategoriaIngrediente.Productos.application.error.ProductoNotFoundException;
import com.frankly221.productoCategoriaIngrediente.Productos.domain.Producto;
import com.frankly221.productoCategoriaIngrediente.Productos.domain.ProductoRepository;

@Service

public class ProductoService {

    // Inyeccion de dependencia de ProductoMapper(Application) y
    // ProductoRepository(domain)
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

//-------------------------------------------------------------------------------------------------------------

    // Se busca el producto por idRestaurante y se devuelve una lista de productosDTO

    public List<ProductoDTO> findByIdrestaurante(int idRestaurante)  {

        List<ProductoDTO> productosDTO = productoRepository.findByIdrestaurante(idRestaurante).stream()
                .map(productoMapper::productoToProductoDTO)
                .toList();
        return productosDTO;

    }
//-------------------------------------------------------------------------------------------------------------

    // Se guarda el producto en la base de datos y se devuelve el productoDTO
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = productoMapper.productoDTOToProducto(productoDTO);
        

        producto.setCreadoEn(Instant.now());
        producto.setActualizadoEn(Instant.now());

        Producto productoGuardado = productoRepository.save(producto);
        productoRepository.save(producto);

        // Se guarda el producto en la base de datos y se devuelve el productoDTO
        ProductoDTO productoGuardadoDTO = productoMapper.productoToProductoDTO(productoGuardado);

        return productoGuardadoDTO;
    }
//-------------------------------------------------------------------------------------------------------------
    // Se busca el producto por idProducto y idRestaurante y se devuelve el productoDTO

    public ProductoDTO findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) throws ProductoNotFoundException {


        Producto producto = productoRepository.findByIdProductoAndIdrestaurante(idProducto, idRestaurante)
        .orElseThrow(() -> new ProductoNotFoundException("El producto no existe en el restaurante"));

    return productoMapper.productoToProductoDTO(producto);
    }
//-------------------------------------------------------------------------------------------------------------
    // Se busca el producto por idProducto y idRestaurante y se devuelve el productoDTO

    public ProductoDTO update(ProductoDTO productoDTO) throws ProductoNotFoundException {
        Producto productoExistente = productoRepository
            .findByIdProductoAndIdrestaurante(productoDTO.getIdProducto(), productoDTO.getIdRestaurante())
            .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado para actualizar"));
    
        // Mapeo de los nuevos valores sobre el objeto existente
        productoMapper.actualizarProductoDesdeDTO(productoDTO, productoExistente);
        productoExistente.setActualizadoEn(Instant.now());
    
        Producto productoActualizado = productoRepository.update(productoExistente);
    
        return productoMapper.productoToProductoDTO(productoActualizado);
    }
//-------------------------------------------------------------------------------------------------------------
    // Se busca el producto por idProducto y idRestaurante y se elimina el producto

    public void deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) throws ProductoNotFoundException {
        productoRepository.findByIdProductoAndIdrestaurante(idProducto, idRestaurante)
            .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado para eliminar"));
    
        productoRepository.deleteByIdProductoAndIdrestaurante(idProducto, idRestaurante);
    }

    //-------------------------------------------------------------------------------------------------------------

    // Se busca el producto por idRestaurante y se devuelve una lista de productosDTO

    public List<ProductoDTO> findByIdCategoria(int idCategoria)  {

        List<ProductoDTO> productosDTO = productoRepository.findByIdCategoria(idCategoria).stream()
                .map(productoMapper::productoToProductoDTO)
                .toList();
        return productosDTO;

    }

}
