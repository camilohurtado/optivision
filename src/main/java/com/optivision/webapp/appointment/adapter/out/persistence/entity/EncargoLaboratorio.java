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
@Table(name = "ENCARGO_LABORATORIO")
public class EncargoLaboratorio {
    @Id
    @Column(name = "ID_ENCARGO")
    private String idEncargo;

    @Column(name = "PROVEEDOR_ID")
    private String proveedorId;

    @Column(name = "FECHA_CREACION_ENCARGO")
    private java.sql.Date fechaCreacionEncargo;

    @Column(name = "FECHA_RECEPCION_ENCARGO")
    private java.sql.Date fechaRecepcionEncargo;

    @Column(name = "COSTO_ENCARGO")
    private Long costoEncargo;

    @Column(name = "ESTADO_ENCARGO")
    private String estadoEncargo;

    @Column(name = "FECHA_ACTUALIZACION")
    private java.sql.Date fechaActualizacion;
}
