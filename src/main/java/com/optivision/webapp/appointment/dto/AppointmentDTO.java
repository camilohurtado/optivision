package com.optivision.webapp.appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.optivision.webapp.appointment.entity.Appointment;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class AppointmentDTO {

    @NotNull
    @Valid
    private Long id;
    @NotNull
    private LocalDate fechaCita;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
    @NotNull
    @JsonFormat(pattern="hh:mm")
    private LocalTime horaCita;
    @NotNull
    private String paciente;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private String motivo;
    private String observaciones;

    public Appointment toEntity(){
        return Appointment.builder()
                .fechaCita(this.fechaCita)
                .fechaCreacion(LocalDate.now())
                .horaCita(this.horaCita.toString())
                .motivoCita(this.motivo)
                .observaciones(this.observaciones)
                .build();
    }

}
