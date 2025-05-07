package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Mapper;

import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.DTO.QueryPIDTO;


@Component
public class MapperQuery {
    public static QueryPIDTO mapToQueryPIDTO(Object[] row) {
        QueryPIDTO queryPIDTO = new QueryPIDTO();
        queryPIDTO.setIdProducto((int) row[0]);
        queryPIDTO.setNombreProducto((String) row[1]);
        queryPIDTO.setIdIngrediente((int) row[2]);
        queryPIDTO.setNombreIngrediente((String) row[3]);
        return queryPIDTO;
    
    }

    // public static ProductoIngrediente mapToProductoIngrediente(QueryPIDTO dto) {
    //     Producto producto = new Producto(dto.getIdProducto(), dto.getNombreProducto());
    //     Ingrediente ingrediente = new Ingrediente(dto.getIdIngrediente(), dto.getNombreIngrediente());
    
    //     return new ProductoIngrediente(producto, ingrediente);
    // }
}
