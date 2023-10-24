/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.service;

import com.kel5.ecommerce.dto.ProductDto;
import java.util.List;

/**
 *
 * @author pinaa
 */
public interface ProductService {
    public List<ProductDto> showData();
    public void deleteData(Long productId);
    public void updateData(ProductDto productDto);
    public void saveData(ProductDto productDto);
    public ProductDto findProductById(Long id);
}
