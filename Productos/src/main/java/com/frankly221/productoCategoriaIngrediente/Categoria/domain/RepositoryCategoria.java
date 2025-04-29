package com.frankly221.productoCategoriaIngrediente.Categoria.domain;

import java.util.List;

public interface RepositoryCategoria {
    //Guardar una categoria
    Categoria save(Categoria categoria);

    //Modificar una categoria
    Categoria update(Categoria categoria);

    //Eliminar una categoria por id
    void deleteByIdCategoria(int idCategoria);

    // Obtener todas las categorias
    List<Categoria> GetAllCategorias(); 


    List<Categoria> GetAllCategoriasTwo(int idProducto);
}
