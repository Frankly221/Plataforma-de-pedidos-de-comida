package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.ProductoIngredienteDTOQuery;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoQueryRepository;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.RepositoryProductoIngrediente;

@Repository
public class MysqlProductoIngredienteRepository implements RepositoryProductoIngrediente, ProductoQueryRepository {

    private final JpaProductosIngredientesRepository jpaProductosIngredientesRepository;
    public MysqlProductoIngredienteRepository(JpaProductosIngredientesRepository jpaProductosIngredientesRepository) {
        this.jpaProductosIngredientesRepository = jpaProductosIngredientesRepository;
    }



    @Override
    public void save(List<ProductoIngrediente> productoIngredientes) {
        //guarda todas las filas de la tabla producto_ingrediente que se le pasen
        jpaProductosIngredientesRepository.saveAll(productoIngredientes);
    }


    @Override
    public ProductoIngrediente update(List<ProductoIngrediente> productoIngrediente, int idProductoIngrediente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteByIdProductoAndIdrestaurante(ProductoIngrediente productoIngrediente, int idProductoIngrediente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByIdProductoAndIdrestaurante'");
    }



    @Override
    public List<ProductoIngredienteDTOQuery> obtenerIngredientesPorProducto(int idProducto) {
        List<Object[]> resultados = jpaProductosIngredientesRepository.findIngredientesByIdProducto(idProducto);

        return resultados.stream()
                .map(result -> new ProductoIngredienteDTOQuery(
                        (int) result[0], // idProducto
                        (String) result[1], // nombreProducto
                        (int) result[2], // idIngrediente
                        (String) result[3]  // nombreIngrediente
                ))
                .collect(Collectors.toList());

    }
    
    
    
}
