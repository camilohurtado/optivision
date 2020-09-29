package com.optivision.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @Column(name = "PRODUCTO_ID")
    private String productoId;

    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;

    @Column(name = "TIPO_PRODUCTO")
    private String tipoProducto;

    @Column(name = "CANTIDAD_ACTUAL")
    private Long cantidadActual;

    @Column(name = "CANTIDAD_MAXIMA")
    private Long cantidadMaxima;

    @Column(name = "CANTIDAD_MINIMA")
    private Long cantidadMinima;

    @Column(name = "PROVEEDOR_ID")
    private String proveedorId;

    @Column(name = "COSTO_X_UNIDAD")
    private Double costoXUnidad;

    @Column(name = "PRECIO_PUBLICO")
    private Double precioPublico;

    @Column(name = "FECHA_CREACION")
    private java.sql.Date fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    private java.sql.Date fechaActualizacion;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
