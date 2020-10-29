package com.optivision.webapp.sale.dto;

import com.optivision.webapp.sale.entity.SaleEntity;
import com.optivision.webapp.sale.entity.SaleItemEntity;
import com.optivision.webapp.sale.enumerator.GeneralSaleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    private long id;
    private String type; //ENUM
    private List<SaleItem> items = new ArrayList<>();
    private double total;
    private double paid;
    private LocalDate creationDate;
    private String patientName;
    private double pending;
    private String stateDesc = "OPEN"; //ENUM
    private int state = 1; //ENUM

    /**
     * Caculate total amount of the sale.
     */
    public void calculateTotal(){
        this.total = this.items.stream()
                .map(saleItem -> saleItem.getProduct())
                .mapToDouble(product -> product.getPrecioPublico() + (product.getPrecioPublico() * GeneralSaleEnum.IVA.getIva()))
                .sum();
    }

    /**
     * Calculate pending amount from the client.
     */
    public void calculatePending(){
        if(this.total > 0 && this.paid < this.total){
            this.pending = this.total - this.paid;
        }else{
            this.pending = 0;
        }
    }

    /**
     * When client add funds to pending money.
     * @param amount
     */
    public void addFundsToPending(double amount){
        if(amount > 0){
            this.paid += amount;
            this.pending -= amount;
        }
    }

    /**
     * Add sale item to actual sale
     * @param item
     */
    public void addItemsToSale(SaleItem item){
        if(item != null){
            if(this.items != null){
                item.setSaleId(this.getId());
                this.items.add(item);
                //this.calculateTotal();
            }
        }
    }

    /**
     *
     * @param item
     */
    public void removeItemFromSale(SaleItem item){
        if(item != null){
            if(this.items != null){
                if(this.items.contains(item)){
                    this.items.remove(item);
                    this.calculateTotal();
                }
            }
        }
    }

    public SaleEntity toEntity(){
        if(this.items != null){
            List<SaleItemEntity> items =
                    this.items.stream()
                            .map(saleItem -> saleItem.toEntity())
                            .collect(Collectors.toList());
        }

        return SaleEntity.builder()
                .abono(this.paid)
                .estadoVenta(this.stateDesc)
                .precioVenta(this.total)
                .saldo(this.pending)
                .tipoVenta(this.type)
                .pacienteId(this.patientName)
                .fechaCreacion(Date.valueOf(LocalDate.now()))
                .fechaActualizacion(Date.valueOf(LocalDate.now()))
                .usuarioCreacion("ADMIN")
                .usuarioActualizacion("ADMIN")
                .items(items != null ? items.stream()
                        .map(saleItem -> saleItem.toEntity())
                        .collect(Collectors.toList()) : List.of())
                .build();
    }
}
