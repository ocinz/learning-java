package com.example.demo.product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request
    ) {
        ProductResponse createdProduct = productService.createProduct(request);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable String id, @Valid @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @PostMapping("/{id}/purchase")
    public ProductResponse purchaseProduct(
            @PathVariable String id,
            @Valid @RequestBody PurchaseProductRequest request
    ) {
        return productService.purchase(id, request);
    }
}
