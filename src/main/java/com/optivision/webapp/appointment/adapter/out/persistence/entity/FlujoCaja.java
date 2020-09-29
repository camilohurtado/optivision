package com.optivision.webapp.appointment.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FLUJO_CAJA")
public class FlujoCaja {
    @Id
    @Column(name = "FLUJO_ID")
    private Long flujoId;

    @Column(name = "FECHA_ENTRADA")
    private java.sql.Date fechaEntrada;

    @Column(name = "HORA_ENTRADA")
    private String horaEntrada;

    @Column(name = "MONTO_ENTRADA")
    private Long montoEntrada;

    @Column(name = "FECHA_SALIDA")
    private java.sql.Date fechaSalida;

    @Column(name = "HORA_SALIDA")
    private String horaSalida;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
