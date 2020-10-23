package com.optivision.webapp.product.enumerator;

public enum GlassFrameMaterial {

    ACETATO("ACETATO"),
    ALUMINIO("ALUMINIO"),
    ANCHO("ANCHO"),
    CLASICO("CLASICO"),
    DEPORTIVAS("DEPORTIVAS"),
    INYECCION("INYECCION"),
    LUJO("LUJO"),
    NYLON("NYLON"),
    PASTA("PASTA");

    String material;


    GlassFrameMaterial(String material) {
        this.material = material;
    }

    public String getValue(){
        return this.material;
    }

}
