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
@Table(name = "DEVOLUCION")
public class Devolucion {
    @Id
    @Column(name = "DEVOLUCION_ID")
    private Long devolucionId;

    @Column(name = "VENTA_ID")
    private String ventaId;

    @Column(name = "MOTIVO")
    private String motivo;

    @Column(name = "FECHA_CREACION")
    private java.sql.Date fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private java.sql.Date fechaModificacion;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "MONTO_DEVUELTO")
    private Long montoDevuelto;
}
