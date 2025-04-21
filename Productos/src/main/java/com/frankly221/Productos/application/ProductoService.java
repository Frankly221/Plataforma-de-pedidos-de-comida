package com.frankly221.Productos.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frankly221.Productos.domain.ProductoRepository;

@Service

public class ProductoService {

    //Inyeccion de dependencia de ProductoMapper(Application) y ProductoRepository(domain)
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





}
