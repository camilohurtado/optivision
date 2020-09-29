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
@Table(name = "PRODUCTOS_X_VENTA")
public class ProductosXVenta {
    @Id
    private String id;

    @Column(name = "ID_VENTA")
    private String idVenta;

    @Column(name = "ID_PRODUCTO")
    private String idProducto;
}
