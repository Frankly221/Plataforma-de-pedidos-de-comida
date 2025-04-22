package com.frankly221.Productos.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frankly221.Productos.application.ProductoDTO;
import com.frankly221.Productos.application.ProductoService;

@RestController
@RequestMapping("/v1/productos")
public class ProductoController {

    //Inyeccion de dependencia de ProductoService(Application)
    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{idRestaurante}")
    public ResponseEntity<List<ProductoDTO>> getProductosByIdRestaurante(@PathVariable int idRestaurante) {

        List<ProductoDTO> productosDTO = productoService.findByIdrestaurante(idRestaurante);
        
        return ResponseEntity.ok(productosDTO); 
    }
    
    @GetMapping("/{idRestaurante}/{idProducto}")
    public ResponseEntity<ProductoDTO> getProductoByIdProductoAndIdRestaurante(
            @PathVariable int idRestaurante, 
            @PathVariable int idProducto) {
        
        Optional<ProductoDTO> productoDTO = productoService.findByIdProductoAndIdrestaurante(idProducto, idRestaurante);
        
        return productoDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO createdProducto = productoService.save(productoDTO);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<ProductoDTO> updateProducto(@RequestBody ProductoDTO productoDTO) {
        Optional<ProductoDTO> updatedProducto = productoService.update(productoDTO);
        
        return updatedProducto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{idRestaurante}/{idProducto}")
    public ResponseEntity<Void> deleteProducto(
            @PathVariable int idRestaurante, 
            @PathVariable int idProducto) {
        
        boolean deleted = productoService.deleteByIdProductoAndIdrestaurante(idProducto, idRestaurante);
        
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
                        new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}