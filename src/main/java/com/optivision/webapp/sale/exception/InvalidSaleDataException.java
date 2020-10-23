package com.optivision.webapp.sale.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidSaleDataException extends RuntimeException{
    public InvalidSaleDataException(String msg){
        super(msg);
    }

    public InvalidSaleDataException(String msg, Throwable ex){
        super(msg, ex);
    }
}
