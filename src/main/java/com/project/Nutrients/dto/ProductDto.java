package com.project.Nutrients.dto;

import com.project.Nutrients.entity.Product;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ProductDto {

    private Long id;
    private String category;
    private String productName;
    private int price;
    private int inventory;

    public Product toEntity() {
        return new Product(id, category, productName, price, inventory);
    }
}
