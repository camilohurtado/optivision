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
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @Column(name = "USUARIO_ID")
    private Long usuarioId;

    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "CONTRASENA_USUARIO")
    private String contrasenaUsuario;

    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;
}
