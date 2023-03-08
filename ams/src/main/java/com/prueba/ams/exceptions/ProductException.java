package com.prueba.ams.exceptions;

public class ProductException extends Exception {

    private String message;

    public ProductException(String message) {
        this.message = message;
    }
}
