package com.frankly221.productoCategoriaIngrediente.Categoria.application.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frankly221.productoCategoriaIngrediente.Categoria.application.DTO.CategoriaDTO;
import com.frankly221.productoCategoriaIngrediente.Categoria.application.Mapper.CategoriaMapper;
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

    public void save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
        categoria.setCreadoEn(Instant.now());
        categoria.setActualizadoEn(Instant.now());
        categoria.setSn("s");
        repositoryCategoria.save(categoria);
       
    }

    public void update(CategoriaDTO categoriaDTO) {
        Categoria categoriaExistente = repositoryCategoria.getByIdCategoria(categoriaDTO.getIdCategoria());
        if (categoriaExistente == null) {
            throw new RuntimeException("Categoria no encontrada");
        }
        categoriaMapper.actualizarCategoriaDesdeDTO(categoriaDTO, categoriaExistente);
        categoriaExistente.setActualizadoEn(Instant.now());

        repositoryCategoria.update(categoriaExistente);

        }
        

    public void deleteByIdCategoria(int idCategoria) {
        Categoria categoriaExistente = repositoryCategoria.getByIdCategoria(idCategoria);
        if (categoriaExistente == null) {
            throw new RuntimeException("Categoria no encontrada");
        }
        categoriaExistente.setActualizadoEn(Instant.now());
        categoriaExistente.setSn("n");

        repositoryCategoria.deleteByIdCategoria(categoriaExistente);
    }

}
