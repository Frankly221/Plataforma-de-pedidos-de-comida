package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.RepositoryProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Entities.ProductoIngredienteJpa;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Output.Persistence.Mapper.MapperProductoIngrediente;

@Repository
public class MysqlProductoIngredienteRepository implements RepositoryProductoIngrediente {

    private final JpaProductosIngredientesRepository jpaProductosIngredientesRepository;
    private final MapperProductoIngrediente mapper;
    public MysqlProductoIngredienteRepository(JpaProductosIngredientesRepository jpaProductosIngredientesRepository,MapperProductoIngrediente mapper) {
        this.jpaProductosIngredientesRepository = jpaProductosIngredientesRepository;
        this.mapper = mapper;
    }



    @Override
    public void save(List<ProductoIngrediente> productoIngredientes) {

        List<ProductoIngredienteJpa> productoIngredienteJpa = productoIngredientes.stream()
                .map(mapper::modelToEntityJpa)
                .toList();

        //guarda todas las filas de la tabla producto_ingrediente que se le pasen
        jpaProductosIngredientesRepository.saveAll( productoIngredienteJpa);
    }


    @Override
    public void update(List<ProductoIngrediente> productoIngrediente) {
               List<ProductoIngredienteJpa> productoIngredienteJpa = productoIngrediente.stream()
                .map(mapper::modelToEntityJpa)
                .toList();

        //guarda todas las filas de la tabla producto_ingrediente que se le pasen
        jpaProductosIngredientesRepository.saveAll( productoIngredienteJpa);

    }

    @Override
    public void deleteByIdProductoIngrediente(ProductoIngrediente productoIngrediente, int idProductoIngrediente) {
        ProductoIngredienteJpa productoIngredienteJpa = mapper.modelToEntityJpa(productoIngrediente);
        jpaProductosIngredientesRepository.save(productoIngredienteJpa);

    }



    @Override
    public List<ProductoIngrediente> buscarIngredientesPorProducto(int idProducto) {
        List<Object[]> lista = jpaProductosIngredientesRepository.findIngredientesByIdProducto(idProducto);

        List<ProductoIngrediente> models = lista.stream()
                .map(mapper::objectToModels)
                .toList();



        return models;
    }



    @Override
    public ProductoIngrediente findByIdProductoIngrediente(int idProductoIngrediente) {
        
        ProductoIngredienteJpa productoIngredienteJpa = jpaProductosIngredientesRepository.findById(idProductoIngrediente).orElse(null);
        if (productoIngredienteJpa != null) {
            return mapper.entityJpaToModel(productoIngredienteJpa);
        } else {
            return null;
        }
    }



    @Override
    public void updateone(ProductoIngrediente productoIngrediente) {

        ProductoIngredienteJpa productoIngredienteJpa = mapper.modelToEntityJpa(productoIngrediente);
        jpaProductosIngredientesRepository.save(productoIngredienteJpa);
    }
   
    
}
