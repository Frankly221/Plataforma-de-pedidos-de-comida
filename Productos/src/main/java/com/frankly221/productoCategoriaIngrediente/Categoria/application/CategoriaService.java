package com.frankly221.productoCategoriaIngrediente.Categoria.application;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frankly221.productoCategoriaIngrediente.Categoria.domain.Categoria;
import com.frankly221.productoCategoriaIngrediente.Categoria.domain.RepositoryCategoria;

@Service

public class CategoriaService {

    private final RepositoryCategoria repositoryCategoria;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(RepositoryCategoria repositoryCategoria, CategoriaMapper categoriaMapper) {
        this.repositoryCategoria = repositoryCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriaDTO> getAllCategorias() {
        return repositoryCategoria.GetAllCategorias().stream()
                .map(categoriaMapper::categoriaToCategoriaDTO)
                .toList();
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
        categoria.setCreadoEn(Instant.now());
        categoria.setActualizadoEn(Instant.now());
        Categoria categoriaGuardada = repositoryCategoria.save(categoria);
        return categoriaMapper.categoriaToCategoriaDTO(categoriaGuardada);
    }

    public CategoriaDTO update(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
        // Se guarda la categoria en la base de datos y se devuelve el productoDTO
        categoriaMapper.actualizarCategoriaDesdeDTO(categoriaDTO, categoria);
        categoria.setActualizadoEn(Instant.now());

        Categoria categoriaActualizado = repositoryCategoria.save(categoria);
        return categoriaMapper.categoriaToCategoriaDTO(categoriaActualizado);
    }

    public void deleteByIdCategoria(int idCategoria) {
        repositoryCategoria.deleteByIdCategoria(idCategoria);
    }


}
