package com.example.demo.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
        @NotBlank
        String name,

        @Positive
        long price,

        @PositiveOrZero
        int stock
) {
}
