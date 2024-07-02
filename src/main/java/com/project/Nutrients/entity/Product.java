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
    private Integer price;
    @Column
    private Integer inventory;

    public void patch(Product product) {
        if (product.category != null) {
            this.category = product.category;
        }
        if (product.productName != null) {
            this.productName = product.productName;
        }
        if (product.price != null) {
            this.price = product.price;
        }
        if (product.inventory != null) {
            this.inventory = product.inventory;
        }
    }
}
