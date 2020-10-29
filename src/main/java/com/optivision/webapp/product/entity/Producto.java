package com.optivision.webapp.product.entity;

import com.optivision.webapp.product.dto.Product;
import com.optivision.webapp.product.enumerator.CaseMaterial;
import com.optivision.webapp.product.enumerator.GlassFrame;
import com.optivision.webapp.product.enumerator.GlassFrameMaterial;
import com.optivision.webapp.product.enumerator.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @Column(name = "producto_id")
    private Long productoId;

    @Column(name = "color")
    private String color;

    @Column(name = "marca")
    private String marca;

    @Column(name = "serie")
    private String serie;

    @Column(name = "tipo_marco")
    private String tipoMarco;

    @Column(name = "material")
    private String material;

    @Column(name = "liquido")
    private String liquido;

    @Column(name = "mililitros_liquido")
    private String mililitrosLiquido;

    @Column(name = "cantidad_actual")
    private Long cantidadActual;

    @Column(name = "cantidad_maxima")
    private Long cantidadMaxima;

    @Column(name = "cantidad_minima")
    private Long cantidadMinima;

    @Column(name = "costo_x_unidad")
    private Double costoXUnidad;

    @Column(name = "fecha_actualizacion")
    private java.sql.Date fechaActualizacion;

    @Column(name = "fecha_creacion")
    private java.sql.Date fechaCreacion;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_publico")
    private Double precioPublico;

    @Column(name = "proveedor_id")
    private String proveedorId;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    public Product toDto(){
        return Product.builder()
                .cantidadActual(this.cantidadActual)
                .cantidadMaxima(this.cantidadMaxima)
                .cantidadMinima(this.cantidadMinima)
                .color(this.color)
                .costoXUnidad(this.costoXUnidad)
                .fechaActualizacion(this.fechaActualizacion != null ? this.fechaActualizacion.toLocalDate() : null)
                .fechaCreacion(this.fechaCreacion != null ? this.fechaCreacion.toLocalDate() : null)
                .marca(this.marca)
                .materialMarco(this.material != null ? GlassFrameMaterial.valueOf(this.material) : null)
                .materialEstuche(this.material != null ? CaseMaterial.valueOf(this.material) : null)
                .mililitrosLiquido(this.mililitrosLiquido)
                .nombreProducto(this.nombreProducto)
                .precioPublico(this.precioPublico)
                .productoId(this.productoId)
                .proveedorId(this.proveedorId)
                .serie(this.serie)
                .tipoMarco(tipoMarco != null ? GlassFrame.valueOf(this.tipoMarco) : null)
                .tipoProducto(this.tipoProducto)
                .usuarioCreacion(this.usuarioCreacion)
                .usuarioModificacion(this.usuarioModificacion)
                .build();
    }
}
