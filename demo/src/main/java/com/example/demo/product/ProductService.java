package com.example.demo.product;

import com.example.demo.common.exception.InsufficientStockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(this::toResponse).toList();
    }

    public ProductResponse getProduct(String id) {
        Product product
                = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return toResponse(product);
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product newProduct = new Product(
                request.name(),
                request.price(),
                request.stock()
        );

        Product savedProduct = productRepository.save(newProduct);

        return toResponse(savedProduct);
    }

    public void deleteProduct(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);
    }

    @Transactional
    public ProductResponse updateProduct(String id, ProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.update(
                request.name(),
                request.price(),
                request.stock()
        );

//        Product savedProduct = productRepository.save(product);

        return toResponse(product);
    }

    @Transactional
    public ProductResponse purchase(String id, PurchaseProductRequest request) {
        Product product = productRepository.findByIdForUpdate(id).orElseThrow(() -> new ProductNotFoundException(id));
        if (product.getStock() < request.quantity()) {
            throw new InsufficientStockException(id);
        }
        product.decreaseStock(request.quantity());
        return toResponse(product);
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }

}
