package com.hong.ecommerce.ecomapi.service; 

public class ProductServiceException extends Exception {
    public ProductServiceException() {
        super();
    }

    public ProductServiceException(String message) {
        super(message);
    }
}
