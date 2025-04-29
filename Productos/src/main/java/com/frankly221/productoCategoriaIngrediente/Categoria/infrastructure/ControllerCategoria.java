package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frankly221.productoCategoriaIngrediente.Categoria.application.CategoriaDTO;
import com.frankly221.productoCategoriaIngrediente.Categoria.application.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoria {

    private final CategoriaService categoriaService;

    public ControllerCategoria(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        List<CategoriaDTO> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(CategoriaDTO categoriaDTO) {
        CategoriaDTO createdCategoria = categoriaService.save(categoriaDTO);
        return ResponseEntity.status(201).body(createdCategoria);
        }
  
    @PutMapping
    public ResponseEntity<CategoriaDTO> updateCategoria(CategoriaDTO categoriaDTO) {
        CategoriaDTO updatedCategoria = categoriaService.update(categoriaDTO);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategoria(int idCategoria) {
        categoriaService.deleteByIdCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }        
}
