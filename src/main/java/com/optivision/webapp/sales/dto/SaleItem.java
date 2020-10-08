package com.optivision.webapp.sales.dto;

import com.optivision.webapp.sales.entity.SaleItemEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class SaleItem {
    private long productId;
    private String name;
    private String type; //ENUM
    private String desc;
    private double price;
    private int actualQuantity;
    private int minimumQuantity;
    private String reference;
    private String make;
    private Sale sale;

    public boolean verifyExistence(){
        if(this.actualQuantity > minimumQuantity + 3){
            return true;
        }
        return false;
    }

    public SaleItemEntity toEntity(){
        return SaleItemEntity.builder()
                .idProducto(this.productId)
                .build();
    }
}
