package com.project.Nutrients.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String category;
    @Column
    private String productName;
    @Column
    private int price;
    @Column
    private int inventory;

    public void patch(Product product) {
        if (product.category != null) {
            this.category = product.category;
        }
        if (product.productName != null) {
            this.productName = product.productName;
        }
        if (product.price != 0) {
            this.price = product.price;
        }
        if (product.inventory != 0) {
            this.inventory = product.inventory;
        }
    }
}
