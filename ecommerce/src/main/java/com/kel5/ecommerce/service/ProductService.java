package com.kel5.ecommerce.service;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(ProductDto productDto) throws Exception;

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);
}
