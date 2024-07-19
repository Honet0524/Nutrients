package com.project.Nutrients.repository;

import com.project.Nutrients.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    ArrayList<Product> findAll();
}
