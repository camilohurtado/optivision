package com.optivision.webapp.sale.dto;

import com.optivision.webapp.product.dto.Product;
import com.optivision.webapp.product.enumerator.ProductType;
import com.optivision.webapp.sale.entity.SaleItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleItem {
    private long saleId;
    private Product product;
    private ProductType type;

    public SaleItemEntity toEntity(){
        return SaleItemEntity.builder()
                //.idProducto(this.product.getProductoId())
                .idProducto(1L)
                .build();
    }
}
