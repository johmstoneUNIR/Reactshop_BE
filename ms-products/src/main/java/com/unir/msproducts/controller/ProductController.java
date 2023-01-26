package com.unir.msproducts.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unir.msproducts.model.pojo.Product;
import com.unir.msproducts.model.request.CreateProductRequest;
import com.unir.msproducts.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    
    private final ProductService service;

    @GetMapping("/HelloWord")
    public String HelloWord(){
        return "Hello mundo a JAVA";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        if(products != null){
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/products/{productID}")
    public ResponseEntity<Product> getProduct(@PathVariable String productID) {

        log.info("Request received for product {}", productID);
        Product product = service.getProduct(productID);

        if(product != null){
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> getProduct(@RequestBody CreateProductRequest request) {
  
      Product createdProduct = service.createProduct(request);
  
      if (createdProduct != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
      } else {
        return ResponseEntity.badRequest().build();
      }
  
    }
}