package com.frankly221.productoCategoriaIngrediente.Productos.infrastructure.Input.Controllers;

import java.util.List;

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

import com.frankly221.productoCategoriaIngrediente.Productos.application.ProductoDTO;
import com.frankly221.productoCategoriaIngrediente.Productos.application.Service.ProductoService;
import com.frankly221.productoCategoriaIngrediente.Productos.application.error.ProductoNotFoundException;

@RestController
@RequestMapping("/v1/productos")
public class ProductoController {

    // Inyeccion de dependencia de ProductoService(Application)
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
            @PathVariable int idProducto) throws ProductoNotFoundException {


                ProductoDTO dto = productoService.findByIdProductoAndIdrestaurante(idProducto, idRestaurante);
                return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO createdProducto = productoService.save(productoDTO);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> updateProducto(@RequestBody ProductoDTO productoDTO) throws  ProductoNotFoundException {
       ProductoDTO updatedProducto = productoService.update(productoDTO);

       return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/{idRestaurante}/{idProducto}")
    public ResponseEntity<Void> deleteProducto(
            @PathVariable int idRestaurante,
            @PathVariable int idProducto) throws  ProductoNotFoundException {

         productoService.deleteByIdProductoAndIdrestaurante(idProducto, idRestaurante);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<ProductoDTO>> getProductosByIdCategoria(@PathVariable int idCategoria) {

        List<ProductoDTO> productosDTO = productoService.findByIdCategoria(idCategoria);

        return ResponseEntity.ok(productosDTO);
    }

}