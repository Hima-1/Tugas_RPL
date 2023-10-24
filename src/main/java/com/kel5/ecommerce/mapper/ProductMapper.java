package com.kel5.ecommerce.mapper;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Image;
import com.kel5.ecommerce.entity.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .productID(product.getProductID())
                .nama(product.getNama())
                .deskripsi(product.getDeskripsi())
                .harga(product.getHarga())
                .stok(product.getStok())
                .berat(product.getBerat())
                .image(product.getImage())
                .createdOn(product.getCreatedOn())
                .updatedOn(product.getUpdatedOn())
                .build();
        return productDto;
    }
    public static Product mapToProduct(ProductDto productDto) {
        Product product = Product.builder()
                .id(productDto.getId())
                .productID(productDto.getProductID())
                .nama(productDto.getNama())
                .deskripsi(productDto.getDeskripsi())
                .harga(productDto.getHarga())
                .stok(productDto.getStok())
                .berat(productDto.getBerat())
                .image(productDto.getImage())
                .createdOn(productDto.getCreatedOn())
                .updatedOn(productDto.getUpdatedOn())
                .build();
        return product;
    }
    
}
