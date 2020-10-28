package com.optivision.webapp.product.enumerator;

public enum GlassFrame {
    COMPLETO("COMPLETO"),
    TRES_PIEZAS("TRES PIEZAS"),
    AL_AIRE("AL AIRE");

    String glassFrame;

    GlassFrame(String glassFrame) {
        this.glassFrame = glassFrame;
    }

    public String getValue(){
        return this.glassFrame;
    }
}
