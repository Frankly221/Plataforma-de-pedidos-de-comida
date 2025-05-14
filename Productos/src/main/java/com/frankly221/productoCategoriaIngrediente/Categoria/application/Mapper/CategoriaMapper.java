package com.frankly221.productoCategoriaIngrediente.Categoria.application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.frankly221.productoCategoriaIngrediente.Categoria.application.DTO.CategoriaDTO;
import com.frankly221.productoCategoriaIngrediente.Categoria.domain.Categoria;

@Component

public class CategoriaMapper {

    private final ModelMapper modelMapper;

    public CategoriaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
        return categoriaDTO;
    }

    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        return categoria;
    }

    public void actualizarCategoriaDesdeDTO(CategoriaDTO categoriaDTO, Categoria categoriaExistente) {
        modelMapper.map(categoriaDTO, categoriaExistente);
    }
    
}
