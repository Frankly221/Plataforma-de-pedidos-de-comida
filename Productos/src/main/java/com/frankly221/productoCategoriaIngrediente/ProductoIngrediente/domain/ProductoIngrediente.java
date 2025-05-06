package com.frankly221.productoCategoriaIngrediente.ProductoIngrediente.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "producto_ingrediente")
public class ProductoIngrediente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_ingrediente")
    private int idProductoIngrediente;

    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "id_ingrediente")
    private int idIngrediente;

    // @Column(name = "creado_en")
    // private Instant creadoEn;

    // @Column(name = "actualizado_en")
    // private Instant actualizadoEn;


    
}
