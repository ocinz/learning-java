package tech.kokage.simpleapi.product;

public record Product(
        Long id,
        String name,
        Long price
) {
}
