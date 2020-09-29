package com.optivision.webapp.appointment.adapter.out.persistence.entity;

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
@Table(name = "VENTA")
public class Venta {
    @Id
    @Column(name = "ID_VENTA")
    private String idVenta;

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
}
