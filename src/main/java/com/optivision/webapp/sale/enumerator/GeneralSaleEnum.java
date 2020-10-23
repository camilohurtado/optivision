package com.optivision.webapp.sale.enumerator;

public enum GeneralSaleEnum {
    IVA(0.19);

    private double iva;

    GeneralSaleEnum(double iva) {
        this.iva = iva;
    }

    public double getIva(){
        return this.iva;
    }
}
