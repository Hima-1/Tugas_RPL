package com.kel5.ecommerce.mapper;

import com.kel5.ecommerce.dto.ProductDTO;
import com.kel5.ecommerce.entity.Image;
import com.kel5.ecommerce.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

import com.kel5.ecommerce.entity.Category;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .nama(product.getNama())
                .deskripsi(product.getDeskripsi())
                .harga(product.getHarga())
                .stok(product.getStok())
                .berat(product.getBerat())
                .categories(product.getCategories().stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList()))
                .images(product.getImage().stream().map(ImageMapper::toImageDTO).collect(Collectors.toList()))
                .build();
    }

    // Product: DTO to Entity
    public static Product toProductEntity(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .nama(productDTO.getNama())
                .deskripsi(productDTO.getDeskripsi())
                .harga(productDTO.getHarga())
                .stok(productDTO.getStok())
                .berat(productDTO.getBerat())
                // For categories and images, you'll need to fetch or create instances as they involve relations
                .build();
    }

    public static List<ProductDTO> toProductDTOs(List<Product> products) {
        return products.stream().map(ProductMapper::toProductDTO).collect(Collectors.toList());
    }
}
