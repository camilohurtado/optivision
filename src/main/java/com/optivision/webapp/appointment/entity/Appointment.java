package com.optivision.webapp.appointment.entity;

import com.optivision.webapp.appointment.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CITA")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITA_ID")
    private BigDecimal citaId;

    @Column(name = "FECHA_CITA")
    private LocalDate fechaCita;

    @Column(name = "HORA_CITA")
    private String horaCita;

    @Column(name = "MOTIVO_CITA")
    private String motivoCita;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private LocalDate fechaModificacion;

    @Column(name = "PACIENTE_ID")
    private Long pacienteId;

    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    public AppointmentDTO toDto(){
        return AppointmentDTO.builder()
                .id(this.citaId.longValue())
                .fechaCita(this.fechaCita)
                .fechaCreacion(this.fechaCreacion)
                .fechaModificacion(this.fechaModificacion)
                .horaCita(LocalTime.parse(this.horaCita))
                .motivo(this.motivoCita)
                .observaciones(this.observaciones)
                .paciente("PACIENTE")
                .usuarioCreacion(this.usuarioCreacion)
                .usuarioModificacion(this.usuarioModificacion)
                .build();
    }

    public boolean verifyAppointmentDates() throws Exception {
        if(this.fechaCita.isBefore(LocalDate.now())){
            throw new Exception("La fecha de la cita es anterior al dia de hoy. Por" +
                    " favor indique una fecha que sea mayor al dia de hoy.");
        }
        return true;
    }
}
