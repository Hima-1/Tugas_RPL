package com.kel5.ecommerce.service.impl;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Image;
import com.kel5.ecommerce.entity.Product;
import com.kel5.ecommerce.repository.ImageRepository;
import com.kel5.ecommerce.repository.ProductRepository;
import com.kel5.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Product saveProduct(ProductDto productDto) throws Exception {
        // Create new Product entity and populate its fields from ProductDto
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setWeight(productDto.getWeight());
        product.setStatus(productDto.getStatus());

        // Create list to hold Image entities
        List<Image> imageEntities = new ArrayList<>();

        // Check if images were uploaded and the count doesn't exceed 3
        if (productDto.getImages() != null && productDto.getImages().size() <= 3) {
            for (MultipartFile imageFile : productDto.getImages()) {
                // Convert MultipartFile to Blob
                Blob blob = new SerialBlob(imageFile.getBytes());

                // Create new Image entity and populate it
                Image image = new Image();
                image.setImage(blob);

                // Save Image entity
                imageRepository.save(image);

                // Add to list of Image entities
                imageEntities.add(image);
            }
            // Associate the list of images with the product
            product.setImage(imageEntities);
        }

        // Save the product and associated images
        return productRepository.save(product);
    }
}
