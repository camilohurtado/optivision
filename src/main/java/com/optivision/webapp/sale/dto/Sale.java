package com.optivision.webapp.venta.dto;

import com.optivision.webapp.venta.entity.SaleEntity;
import com.optivision.webapp.venta.entity.SaleItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    private long id;
    private String type; //ENUM
    //private List<SaleItem> items;
    private Collection<SaleItem> items;
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
                .mapToDouble(value -> value.getPrice() + (value.getPrice() * 0.19))
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
                item.setSale(this);
                this.items.add(item);
                this.calculateTotal();
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
                //.items(items)
                .build();
    }
}
