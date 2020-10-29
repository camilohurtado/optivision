package com.optivision.webapp.product.enumerator;

public enum CaseStyle {
    LUJO("Lujo"),
    DEPORTIVO("Deportivo"),
    FUNDA("Funda"),
    LENTES("Lentes"),
    CORREA("Correa"),
    BAUL("Baul");

    private String style;

    CaseStyle(String style){
        this.style = style;
    }

    public String getStyle(){
        return this.style;
    }
}
