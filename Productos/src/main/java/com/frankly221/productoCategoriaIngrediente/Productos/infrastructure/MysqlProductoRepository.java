package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Productos.domain.Producto;
import com.frankly221.productoCategoriaIngrediente.Productos.domain.ProductoRepository;

@Repository
public class MysqlProductoRepository implements ProductoRepository {

     //Inyeccion de dependencia de JpaProductoRepository
    private final JpaProductoRepository jpaProductoRepository;
    public MysqlProductoRepository(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;

    }

    @Override
    public Producto save(Producto producto) {
        return jpaProductoRepository.save(producto);
    }

    @Override
    public Optional<Producto> findByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
        return  jpaProductoRepository.findByIdProductoAndIdRestaurante(idProducto, idRestaurante);
    }

    @Override
    public Producto update(Producto producto) {
        return jpaProductoRepository.save(producto);
    }

    @Override
    public List<Producto> findByIdrestaurante(int idRestaurante) {
        return jpaProductoRepository.findByIdRestaurante(idRestaurante);
    }

    @Override
    public void deleteByIdProductoAndIdrestaurante(int idProducto, int idRestaurante) {
       jpaProductoRepository.deleteByIdProductoAndIdRestaurante(idProducto, idRestaurante);
    }

    @Override
    public List<Producto> findByIdCategoria(int idCategoria) {
        return jpaProductoRepository.findByIdCategoria(idCategoria);
    }
    
}
