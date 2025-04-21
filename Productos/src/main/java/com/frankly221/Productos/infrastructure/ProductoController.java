package com.frankly221.Productos.infrastructure;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        if ( productosDTO != null) {
            return new ResponseEntity<>( productosDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
