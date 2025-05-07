package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.Models.Producto;
import com.frankly221.productoCategoriaIngrediente.Productos.domain.Repository.ProductoRepository;
import com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Entities.ProductoJpa;
import com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Output.Persistence.Mappers.MapperJpaToModels;

@Repository
public class MysqlProductoRepository implements ProductoRepository {

     //Inyeccion de dependencia de JpaProductoRepository
    private final JpaProductoRepository jpaProductoRepository;
    private final MapperJpaToModels mapperJpaToModels;

    public MysqlProductoRepository(JpaProductoRepository jpaProductoRepository, MapperJpaToModels mapperJpaToModels) {
        this.jpaProductoRepository = jpaProductoRepository;
        this.mapperJpaToModels = mapperJpaToModels;
    }

    @Override
    public Producto save(Producto producto) {
        ProductoJpa productoJpa = mapperJpaToModels.productoToProductoJpa(producto);
        ProductoJpa savedProductoJpa = jpaProductoRepository.save(productoJpa);
        return mapperJpaToModels.productoJpaToProducto(savedProductoJpa);    
    }

    @Override
    public Optional<Producto> findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
        return  jpaProductoRepository.findByIdProductoAndIdRestaurante(idProducto, idRestaurante)
                .map(mapperJpaToModels::productoJpaToProducto);
    }

    @Override
    public Producto update(Producto producto) {
        ProductoJpa productoJpa = mapperJpaToModels.productoToProductoJpa(producto);
        ProductoJpa updatedProductoJpa = jpaProductoRepository.save(productoJpa);
        return mapperJpaToModels.productoJpaToProducto(updatedProductoJpa);
    }

    @Override
    public List<Producto> findByIdrestaurante(int idRestaurante) {
        return jpaProductoRepository.findByIdRestaurante(idRestaurante).stream()
                .map(mapperJpaToModels::productoJpaToProducto)
                .toList();
    }

    @Override
    public void deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
       jpaProductoRepository.deleteByIdProductoAndIdRestaurante(idProducto, idRestaurante);
    }

    @Override
    public List<Producto> findByIdCategoria(int idCategoria) {
        return jpaProductoRepository.findByIdCategoria(idCategoria).stream()
                .map(mapperJpaToModels::productoJpaToProducto)
                .toList();
    }
    
}
