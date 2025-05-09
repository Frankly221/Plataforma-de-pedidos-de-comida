package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.infrastructure.Input.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.DTO.ProductoIngredienteListDTO;
import com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.application.Service.ServiceProductoIngrediente;

@RestController
@RequestMapping("/v1/producto-ingrediente")

public class ControllerProductoIngrediente {

    private final ServiceProductoIngrediente serviceProductoIngrediente;

    public ControllerProductoIngrediente(ServiceProductoIngrediente serviceProductoIngrediente) {
        this.serviceProductoIngrediente = serviceProductoIngrediente;
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoIngredienteListDTO> getIngredientesByIdProducto(@PathVariable int idProducto) {
        
        ProductoIngredienteListDTO listPI = serviceProductoIngrediente.findByIdProducto(idProducto);

        return ResponseEntity.ok(listPI);
    }

    
}
