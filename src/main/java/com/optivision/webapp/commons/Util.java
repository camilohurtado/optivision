package com.optivision.webapp.commons;

import com.optivision.webapp.product.enumerator.CaseMaterial;
import com.optivision.webapp.product.enumerator.GlassFrameMaterial;
import com.optivision.webapp.product.enumerator.ProductType;

public class Util {

    public static boolean isValid(String material){
        GlassFrameMaterial m = Enum.valueOf(GlassFrameMaterial.class, material);
        if(m != null) return true;
        return false;
    }

    public static boolean productIsValid(String value){
        ProductType p = Enum.valueOf(ProductType.class, value);
        if(p != null) return true;
        return false;
    }

    public static boolean materialCaseIsValid(String value){
        CaseMaterial p = Enum.valueOf(CaseMaterial.class, value);
        if(p != null) return true;
        return false;
    }
}
