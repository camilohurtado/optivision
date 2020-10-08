package com.optivision.webapp.sales.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "VENTA")
public class SaleEntity {
    @Id @GeneratedValue
    @Column(name = "ID_VENTA")
    private Long idVenta;

    @Column(name = "TIPO_VENTA")
    private String tipoVenta;

    @Column(name = "PACIENTE_ID")
    private String pacienteId;

    @Column(name = "ESTADO_VENTA")
    private String estadoVenta;

    @Column(name = "ABONO")
    private Double abono;

    @Column(name = "PRECIO_VENTA")
    private Double precioVenta;

    @Column(name = "SALDO")
    private Double saldo;

    @Column(name = "FECHA_CREACION")
    private java.sql.Date fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    private java.sql.Date fechaActualizacion;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "USUARIO_ACTUALIZACION")
    private String usuarioActualizacion;

    @OneToMany(mappedBy = "sale",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SaleItemEntity> items;
}
