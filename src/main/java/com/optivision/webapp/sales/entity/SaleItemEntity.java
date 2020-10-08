package com.optivision.webapp.sales.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ITEM_VENTA")
public class SaleItemEntity {
    @Id @GeneratedValue
    @Column(name = "ID_ITEM_VENTA")
    private Long id;

    @Column(name = "ID_VENTA")
    private Long idVenta;

    @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    private SaleEntity sale;
}
