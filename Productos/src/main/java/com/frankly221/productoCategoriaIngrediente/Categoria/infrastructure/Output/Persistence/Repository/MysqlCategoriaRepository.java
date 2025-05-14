package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frankly221.productoCategoriaIngrediente.Categoria.domain.Categoria;
import com.frankly221.productoCategoriaIngrediente.Categoria.domain.RepositoryCategoria;
import com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Entities.CategoriaJpa;
import com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Output.Persistence.Mapper.JpatoModelCategoria;

@Repository

public class MysqlCategoriaRepository implements RepositoryCategoria{

    //Inyeccion de dependencia de JpaCategoriaRepository
    private final JpaCategoriaRepository jpaCategoriaRepository;
    //Inyeccion de dependencia de JpatoModelCategoria
    private final JpatoModelCategoria jpaToModelCategoria;
    public MysqlCategoriaRepository(JpaCategoriaRepository jpaCategoriaRepository,JpatoModelCategoria jpaToModelCategoria) {
        this.jpaCategoriaRepository = jpaCategoriaRepository;
        this.jpaToModelCategoria = jpaToModelCategoria;
    }

    @Override
    public void save(Categoria categoria) {
    CategoriaJpa categoriaJpa = jpaToModelCategoria.CategoriaModelToJpa(categoria);
    jpaCategoriaRepository.save(categoriaJpa);      
 

    }

    @Override
    public void update(Categoria categoria) {
        CategoriaJpa categoriaJpa = jpaToModelCategoria.CategoriaModelToJpa(categoria);
        jpaCategoriaRepository.save(categoriaJpa);  
    }

    @Override
    public void deleteByIdCategoria(Categoria categoria) {
        CategoriaJpa categoriaJpa = jpaToModelCategoria.CategoriaModelToJpa(categoria);
        jpaCategoriaRepository.save(categoriaJpa);  
    }

    @Override
    public List<Categoria> GetAllCategorias() {
        List<CategoriaJpa> categoriasJpa = jpaCategoriaRepository.findAll();
        return categoriasJpa.stream()
                .map(jpaToModelCategoria::CategoriaJpaToModel)
                .toList();
    }

    @Override
    public Categoria getByIdCategoria(int idCategoria) {
        CategoriaJpa categoriaJpa = jpaCategoriaRepository.findById(idCategoria).orElse(null);
        return jpaToModelCategoria.CategoriaJpaToModel(categoriaJpa);
    }
    
}
