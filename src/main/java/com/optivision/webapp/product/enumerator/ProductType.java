package com.optivision.webapp.product.enumerator;

public enum ProductType {
    MARCO("MARCO"),
    AUMENTO("AUMENTO"),
    ESTUCHE("ESTUCHE"),
    LENTES("FRESHLOOK"),
    LIQUIDO("LIQUIDO");

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
