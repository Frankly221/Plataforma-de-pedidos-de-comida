package com.frankly221.Productos.application;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frankly221.Productos.domain.Producto;
import com.frankly221.Productos.domain.ProductoRepository;

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

    public List<ProductoDTO> findByIdrestaurante(int idRestaurante) {
        List<ProductoDTO> productosDTO = productoRepository.findByIdrestaurante(idRestaurante).stream()
                .map(productoMapper::productoToProductoDTO)
                .toList();
        return productosDTO;

    }

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

    public Optional<ProductoDTO> findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
        Optional<Producto> producto = productoRepository.findByIdProductoAndIdrestaurante(idProducto, idRestaurante);

        Optional<ProductoDTO> productoDTO = producto.map(productoMapper::productoToProductoDTO);

        return productoDTO;
    }

    public Optional<ProductoDTO> update(ProductoDTO productoDTO) {
        Optional<Producto> productoExistente = productoRepository
            .findByIdProductoAndIdrestaurante(productoDTO.getIdProducto(), productoDTO.getIdRestaurante());
    
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
    
            // Mapeo de los nuevos valores sobre el objeto existente
            productoMapper.actualizarProductoDesdeDTO(productoDTO, producto);
    
            producto.setActualizadoEn(Instant.now());
    
            Producto productoActualizado = productoRepository.update(producto);
            return Optional.of(productoMapper.productoToProductoDTO(productoActualizado));
        }
    
        return Optional.empty();
    }

    public boolean deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
        Optional<Producto> producto = productoRepository.findByIdProductoAndIdrestaurante(idProducto, idRestaurante);
    
        if (producto.isPresent()) {
            productoRepository.deleteByIdProductoAndIdrestaurante(idProducto, idRestaurante);
            return true;
        }
    
        return false; // o lanza una excepción personalizada si prefieres
    }

}
