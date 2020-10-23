package com.optivision.webapp.product.dto;

import com.optivision.webapp.product.enumerator.CaseMaterial;
import com.optivision.webapp.product.enumerator.GlassFrame;
import com.optivision.webapp.product.enumerator.GlassFrameMaterial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long productoId;
    private String color;
    private String marca;
    private String serie;
    private GlassFrame tipoMarco;
    private GlassFrameMaterial materialMarco;
    private CaseMaterial materialEstuche;
    private String liquido;
    private String mililitrosLiquido;
    private Long cantidadActual;
    private Long cantidadMaxima;
    private Long cantidadMinima;
    private Double costoXUnidad;
    private LocalDate fechaActualizacion;
    private LocalDate fechaCreacion;
    private String nombreProducto;
    private Double precioPublico;
    private String proveedorId;
    private String tipoProducto;
    private String usuarioCreacion;
    private String usuarioModificacion;
}
