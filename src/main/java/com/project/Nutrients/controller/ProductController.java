package com.project.Nutrients.controller;

import com.project.Nutrients.dto.ProductDto;
import com.project.Nutrients.entity.Product;
import com.project.Nutrients.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public ArrayList<Product> index() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product show(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/product")
    public Product registration(ProductDto dto) {
        Product product = dto.toEntity();
        log.info(product.toString());
        if (product.getId() == null) {
            return null;
        }
        if (product.getProductName() == null) {
            return null;
        }
        if (product.getPrice() == 0) {
            return null;
        }
        if (product.getInventory() == 0) {
            return null;
        }
        return productRepository.save(product);
    }

    @PatchMapping("/product/{id}")
    public Product update(@PathVariable Long id,
                          ProductDto dto) {
        Product product = dto.toEntity();
        log.info(product.toString());
        Product target = productRepository.findById(id).orElse(null);
        if (target == null || id != product.getId()) {
            log.info("잘못된 요청! product: {}", product.toString());
        }
        target.patch(product);
        Product updated = productRepository.save(target);
        return target;
    }

    @DeleteMapping("/product/{id}")
    public Product delete(@PathVariable Long id) {
        Product target = productRepository.findById(id).orElse(null);
        log.info(target.toString());
        if (target == null) {
            return null;
        }
        productRepository.delete(target);
        return target;
    }
}
