package com.optivision.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {
    @Id
    @Column(name = "ID_PROVEEDOR")
    private String idProveedor;

    @Column(name = "NOMBE_PROVEEDOR")
    private String nombeProveedor;

    @Column(name = "TIPO_PROVEEDOR")
    private String tipoProveedor;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    @Column(name = "FECHA_CREACION")
    private java.sql.Date fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private java.sql.Date fechaModificacion;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
