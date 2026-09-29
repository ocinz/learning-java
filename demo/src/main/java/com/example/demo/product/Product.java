package com.example.demo.product;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int stock;

    private long price;

    protected Product() {
    }

    public Product(String name, long price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public String getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void update(String name, Long price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void decreaseStock(int quantity) {
        this.stock -= quantity;
    }
}
