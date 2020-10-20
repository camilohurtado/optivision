package com.optivision.webapp.commons;

import com.optivision.webapp.product.enumerator.MaterialCases;
import com.optivision.webapp.product.enumerator.MaterialGlasses;
import com.optivision.webapp.product.enumerator.Producto;

public class Util {

    public static boolean isValid(String material){
        MaterialGlasses m = Enum.valueOf(MaterialGlasses.class, material);
        if(m != null) return true;
        return false;
    }

    public static boolean productIsValid(String value){
        Producto p = Enum.valueOf(Producto.class, value);
        if(p != null) return true;
        return false;
    }

    public static boolean materialCaseIsValid(String value){
        MaterialCases p = Enum.valueOf(MaterialCases.class, value);
        if(p != null) return true;
        return false;
    }
}
