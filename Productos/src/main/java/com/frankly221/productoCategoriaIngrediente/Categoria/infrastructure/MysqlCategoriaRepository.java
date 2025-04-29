package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Categoria.domain.Categoria;
import com.frankly221.productoCategoriaIngrediente.Categoria.domain.RepositoryCategoria;

@Repository

public class MysqlCategoriaRepository implements RepositoryCategoria{

    //Inyeccion de dependencia de JpaCategoriaRepository
    private final JpaCategoriaRepository jpaCategoriaRepository;
    public MysqlCategoriaRepository(JpaCategoriaRepository jpaCategoriaRepository) {
        this.jpaCategoriaRepository = jpaCategoriaRepository;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return jpaCategoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return jpaCategoriaRepository.save(categoria);
    }

    @Override
    public void deleteByIdCategoria(int idCategoria) {
        jpaCategoriaRepository.deleteById(idCategoria);
    }

    @Override
    public List<Categoria> GetAllCategorias() {
        return jpaCategoriaRepository.findAll();
    }
    
}
