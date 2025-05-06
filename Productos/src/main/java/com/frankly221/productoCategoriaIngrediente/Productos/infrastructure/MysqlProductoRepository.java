package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.ProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.Productos.domain.ProductoRepository;

@Repository
public class MysqlProductoRepository implements ProductoRepository {

     //Inyeccion de dependencia de JpaProductoRepository
    private final JpaProductoRepository jpaProductoRepository;
    public MysqlProductoRepository(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;

    }

    @Override
    public ProductoIngrediente save(ProductoIngrediente producto) {
        return jpaProductoRepository.save(producto);
    }

    @Override
    public Optional<ProductoIngrediente> findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
        return  jpaProductoRepository.findByIdProductoAndIdRestaurante(idProducto, idRestaurante);
    }

    @Override
    public ProductoIngrediente update(ProductoIngrediente producto) {
        return jpaProductoRepository.save(producto);
    }

    @Override
    public List<ProductoIngrediente> findByIdrestaurante(int idRestaurante) {
        return jpaProductoRepository.findByIdRestaurante(idRestaurante);
    }

    @Override
    public void deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
       jpaProductoRepository.deleteByIdProductoAndIdRestaurante(idProducto, idRestaurante);
    }

    @Override
    public List<ProductoIngrediente> findByIdCategoria(int idCategoria) {
        return jpaProductoRepository.findByIdCategoria(idCategoria);
    }
    
}
