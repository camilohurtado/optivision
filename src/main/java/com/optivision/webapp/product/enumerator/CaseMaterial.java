package com.optivision.webapp.product.enumerator;

public enum CaseMaterial {
    CARTERA("Cartera"),
    CIERRE("Cierre"),
    CORDON("Cordon"),
    COSMETIQUERO("Cosmetiquero"),
    CUERO("Cuero"),
    DGRANDE("D. Grande"),
    LENTILLAS("Lentillas"),
    PLASTICO("Plastico"),
    SINTETICO("Sintetico"),
    TELA("Tela");

    String material;

    CaseMaterial(String material) {
        this.material = material;
    }

    public String getMaterial(){
        return this.material;
    }
}
