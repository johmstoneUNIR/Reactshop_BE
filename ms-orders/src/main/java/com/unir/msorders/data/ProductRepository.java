package com.unir.msorders.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.msorders.model.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> name(String name);
    
}
