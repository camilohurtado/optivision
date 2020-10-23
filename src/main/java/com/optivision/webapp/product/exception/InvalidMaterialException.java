package com.optivision.webapp.product.exception;

public class InvalidMaterialException extends RuntimeException{

    public InvalidMaterialException(String message) {
        super(message);
    }

    public InvalidMaterialException(String message, Throwable cause) {
        super(message, cause);
    }
}
