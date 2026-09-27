package tech.kokage.simpleapi.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "Mechanical Keyboard", 500_000L),
            new Product(2L, "Gaming Mouse", 250_000L),
            new Product(3L, "Monitor", 3_000_000L)
    );

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProduct(Long id) {
        return products.stream()
                .filter(product -> product.id().equals(id))
                .findFirst();
    }
}
