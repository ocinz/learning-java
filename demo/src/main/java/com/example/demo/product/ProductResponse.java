package com.example.demo.product;

public record ProductResponse(
        String id,
        String name,
        Long price,
        Integer stock
) {
}
