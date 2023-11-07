package com.kel5.ecommerce.service;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(ProductDto productDto) throws Exception;

    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);


}
