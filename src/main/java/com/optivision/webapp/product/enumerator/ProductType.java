package com.optivision.webapp.product.enumerator;

public enum ProductType {
    MARCO("MARCO"),
    GAFAS_AUMENTO("GAFAS AUMENTO"),
    ESTUCHE("ESTUCHE"),
    LENTES_DE_CONTACTO_COLORES("FRESHLOOK");

    String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getValue(){
        return this.type;
    }
    public ProductType getVaue(String value){
        return ProductType.valueOf(value);
    }
}
