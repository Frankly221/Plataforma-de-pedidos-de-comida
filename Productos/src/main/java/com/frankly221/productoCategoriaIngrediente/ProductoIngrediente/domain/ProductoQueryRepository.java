package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;

import java.util.List;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.ProductoIngredienteDTOQuery;



public interface ProductoQueryRepository {
    List<ProductoIngredienteDTOQuery> obtenerIngredientesPorProducto(int idProducto);
    
}
