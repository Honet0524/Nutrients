package com.project.Nutrients.controller;

import com.project.Nutrients.dto.ProductDto;
import com.project.Nutrients.entity.Product;
import com.project.Nutrients.repository.ProductRepository;
import com.project.Nutrients.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public ArrayList<Product> index() {
        return productService.index();
    }

    @GetMapping("/product/{id}")
    public Product show(@PathVariable Long id) {
        return productService.show(id);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> registration(@RequestBody ProductDto dto) {
        Product registration = productService.registration(dto);
        return (registration != null) ?
                ResponseEntity.status(HttpStatus.OK).body(registration) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                          @RequestBody ProductDto dto) {
        Product updated = productService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product deleted = productService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
