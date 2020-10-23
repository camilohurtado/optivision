package com.optivision.webapp.product.enumerator;

public enum GlassFrame {
    COMPLETO("Completo"),
    TRES_PIEZAS("Tres piezas"),
    AL_AIRE("Al aire");

    String glassFrame;

    GlassFrame(String glassFrame) {
        this.glassFrame = glassFrame;
    }

    public String getValue(){
        return this.glassFrame;
    }
}
