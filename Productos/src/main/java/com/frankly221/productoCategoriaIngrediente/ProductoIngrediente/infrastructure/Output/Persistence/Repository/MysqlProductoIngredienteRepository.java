package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.RepositoryProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Mapper.MapperProductoIngrediente;

@Repository
public class MysqlProductoIngredienteRepository implements RepositoryProductoIngrediente {

    private final JpaProductosIngredientesRepository jpaProductosIngredientesRepository;
    private final MapperProductoIngrediente productoIngredienteMapper;
    public MysqlProductoIngredienteRepository(JpaProductosIngredientesRepository jpaProductosIngredientesRepository,MapperProductoIngrediente productoIngredienteMapper) {
        this.jpaProductosIngredientesRepository = jpaProductosIngredientesRepository;
        this.productoIngredienteMapper = productoIngredienteMapper;
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
    public List<ProductoIngrediente> buscarIngredientesPorProducto(int idProducto) {
        return null;
    }
   
    
}
