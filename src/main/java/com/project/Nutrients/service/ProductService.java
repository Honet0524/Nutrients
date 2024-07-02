package com.project.Nutrients.service;

import com.project.Nutrients.dto.ProductDto;
import com.project.Nutrients.entity.Product;
import com.project.Nutrients.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ArrayList<Product> index() {
        return productRepository.findAll();
    }

    public Product show(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product registration(ProductDto dto) {
        Product product = dto.toEntity();
        log.info(product.toString());
        if (product.getId() != null) {
            return null;
        }
        if (product.getProductName() == null) {
            log.info("상품 이름을 입력주세요.");
            return null;
        }
        if (product.getPrice() == 0) {
            log.info("상품의 가격을 입력해주세요.");
            return null;
        }
        if (product.getInventory() == 0) {
            log.info("상품의 재고를 입력해주세요.");
            return null;
        }
        return productRepository.save(product);
    }

    public Product update(Long id, ProductDto dto) {
        Product product = dto.toEntity();
        log.info(product.toString());
        Product target = productRepository.findById(id).orElse(null);
        if (target == null || id != product.getId()) {
            log.info("잘못된 요청! product: {}", product.toString());
        }
        target.patch(product);
        Product updated = productRepository.save(target);
        return updated;
    }

    public Product delete(Long id) {
        Product target = productRepository.findById(id).orElse(null);
        log.info(target.toString());
        if (target == null) {
            return null;
        }
        productRepository.delete(target);
        return target;
    }
}
