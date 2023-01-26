package com.unir.msproducts.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.msproducts.model.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> name(String name);
    
}
