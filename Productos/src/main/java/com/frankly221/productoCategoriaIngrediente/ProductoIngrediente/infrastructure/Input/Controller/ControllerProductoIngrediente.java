package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Input.Controller;

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

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO.ProductoIngredienteListDTO;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.Service.ServiceProductoIngrediente;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain.ProductoIngrediente;

@RestController
@RequestMapping("/v1/producto-ingrediente")
public class ControllerProductoIngrediente {

    private final ServiceProductoIngrediente serviceProductoIngrediente;

    public ControllerProductoIngrediente(ServiceProductoIngrediente serviceProductoIngrediente) {
        this.serviceProductoIngrediente = serviceProductoIngrediente;
    }

    // GET: Buscar ingredientes de un producto
    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoIngredienteListDTO> getIngredientesByIdProducto(@PathVariable int idProducto) {
        ProductoIngredienteListDTO listPI = serviceProductoIngrediente.findByIdProducto(idProducto);
        return ResponseEntity.ok(listPI);
    }

    // POST: Guardar lista de producto-ingredientes
    @PostMapping
    public ResponseEntity<Void> saveProductoIngrediente(@RequestBody List<ProductoIngrediente> productoIngredienteList) {
        serviceProductoIngrediente.save(productoIngredienteList);
        return ResponseEntity.ok().build();
    }

    // PUT: Actualizar lista de producto-ingredientes
    @PutMapping
    public ResponseEntity<Void> updateProductoIngrediente(@RequestBody List<ProductoIngrediente> productoIngredienteList) {
        serviceProductoIngrediente.update(productoIngredienteList);
        return ResponseEntity.ok().build();
    }

    // DELETE: Borrado lógico de un producto-ingrediente
    @DeleteMapping("/{idProductoIngrediente}")
    public ResponseEntity<Void> deleteProductoIngrediente(@PathVariable int idProductoIngrediente) {
        serviceProductoIngrediente.deleteByIdProductoAndIdrestaurante(idProductoIngrediente);
        return ResponseEntity.noContent().build();
    }
}