package com.frankly221.productoCategoriaIngrediente.Categoria.domain;

import java.util.List;

public interface RepositoryCategoria {
    //Guardar una categoria
    void save(Categoria categoria);

    //Modificar una categoria
    void update(Categoria categoria);

    //Eliminar una categoria por id
    void deleteByIdCategoria(Categoria categoria);

    // Obtener todas las categorias
    List<Categoria> GetAllCategorias();

    // Obtener una categoria por id
    Categoria getByIdCategoria(int idCategoria);

}
