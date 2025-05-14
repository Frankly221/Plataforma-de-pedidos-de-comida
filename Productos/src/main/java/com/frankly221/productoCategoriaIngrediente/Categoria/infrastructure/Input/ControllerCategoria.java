package com.frankly221.productoCategoriaIngrediente.Categoria.infrastructure.Input;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frankly221.productoCategoriaIngrediente.Categoria.application.DTO.CategoriaDTO;
import com.frankly221.productoCategoriaIngrediente.Categoria.application.Service.CategoriaService;

@RestController
@RequestMapping("/v1/categorias")
public class ControllerCategoria {

    private final CategoriaService categoriaService;

    public ControllerCategoria(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @PostMapping
    public ResponseEntity<Void> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.save(categoriaDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateCategoria( @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.update(categoriaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable int id) {
        categoriaService.deleteByIdCategoria(id);
        return ResponseEntity.ok().build();
    }
}