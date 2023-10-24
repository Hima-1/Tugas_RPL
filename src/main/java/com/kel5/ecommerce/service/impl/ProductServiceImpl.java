/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.service.impl;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Product;
import com.kel5.ecommerce.mapper.ProductMapper;
import com.kel5.ecommerce.repository.ProductRepository;
import com.kel5.ecommerce.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author pinaa
 */

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public List<ProductDto> showData() {
        List<Product> products = this.productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map((product) -> (ProductMapper.mapToProductDto(product)))
                .collect(Collectors.toList());        
        return productDtos;
    }
    
    @Override
    public void deleteData(Long productId) {
        productRepository.deleteById(productId);        
    }
    
    @Override
    public void updateData(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        System.out.println(productDto);
        productRepository.save(product);
    }
    
    @Override
    public void saveData(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        productRepository.save(product);
    }

    @Override
    public ProductDto findProductById(Long id) {
        Product pdt = productRepository.findById(id).get();
        return  ProductMapper.mapToProductDto(pdt);
    }
}
