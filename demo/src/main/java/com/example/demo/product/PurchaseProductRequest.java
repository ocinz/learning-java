package com.example.demo.product;

import jakarta.validation.constraints.Positive;

public record PurchaseProductRequest (
        @Positive
        int quantity
) {
}
