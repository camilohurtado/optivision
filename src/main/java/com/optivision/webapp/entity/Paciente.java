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
@Table(name = "PACIENTE")
public class Paciente {
    @Id
    @Column(name = "PACIENTE_ID")
    private Long pacienteId;

    @Column(name = "NOMBRE_PACIENTE")
    private String nombrePaciente;

    @Column(name = "TELEFONO_PACIENTE")
    private String telefonoPaciente;
}
