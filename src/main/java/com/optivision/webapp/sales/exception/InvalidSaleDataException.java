package com.optivision.webapp.sales.exception;

import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.criteria.CriteriaBuilder;

@NoArgsConstructor
public class InvalidSaleDataException extends RuntimeException{
    public InvalidSaleDataException(String msg){
        super(msg);
    }

    public InvalidSaleDataException(String msg, Throwable ex){
        super(msg, ex);
    }
}
