package com.example.demo.common.exception;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String productId) {
        super("Insufficient stock for product " + productId);
    }
}
