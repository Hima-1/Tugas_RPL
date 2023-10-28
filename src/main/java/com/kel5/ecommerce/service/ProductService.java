package com.kel5.ecommerce.service;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Product;

public interface ProductService {
    Product saveProduct(ProductDto productDto) throws Exception;
}
