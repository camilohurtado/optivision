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
    private String name;
    private ProductType type; //ENUM
    private String desc;
    private double price;
    private int actualQuantity;
    private int minimumQuantity;
    private String reference;
    private String make;
    private Sale sale;
    List<Product> products;

    public boolean verifyExistence(){
        if(this.actualQuantity > minimumQuantity + 3){
            return true;
        }
        return false;
    }

    public SaleItemEntity toEntity(){
        return SaleItemEntity.builder()
                .idProducto(this.product.getProductoId())
                .build();
    }
}
