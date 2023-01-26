package com.unir.msproducts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.msproducts.data.ProductRepository;
import com.unir.msproducts.model.pojo.Product;
import com.unir.msproducts.model.request.CreateProductRequest;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository respository;

    @Override
    public List<Product> getProducts() {
        List<Product> products = respository.findAll();
        return products.isEmpty() ? null : products;
    }

    @Override
    public Product getProduct(String productID) {
        return respository.findById(Long.valueOf(productID)).orElse(null);
    }

    @Override
    public Product createProduct(CreateProductRequest request) {

        if(request != null 
                && StringUtils.hasLength(request.getName().trim())
                && StringUtils.hasLength(request.getImageurl().trim())) {
                    Product product = Product.builder().name(request.getName()).price(request.getPrice()).imageurl(request.getImageurl()).isvisible(true).build();
                    return respository.save(product);
                } else {
                    return null;
                }
    }
}
