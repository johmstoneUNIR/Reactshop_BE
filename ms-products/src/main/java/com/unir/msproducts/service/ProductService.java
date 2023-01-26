package com.unir.msproducts.service;

import java.util.List;

import com.unir.msproducts.model.pojo.Product;
import com.unir.msproducts.model.request.CreateProductRequest;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(String productid);

    Product createProduct(CreateProductRequest request);
}
