package com.kel5.ecommerce.service.impl;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Image;
import com.kel5.ecommerce.entity.Product;
import com.kel5.ecommerce.exception.ResourceNotFoundException;
import com.kel5.ecommerce.repository.ProductRepository;
import com.kel5.ecommerce.service.ProductService;
import com.kel5.ecommerce.util.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        // Update properties of existingProduct with those from product
        // ...
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> product = getProductById(id);
        productRepository.delete(product.get());
    }

    @Override
    public Product saveProduct(ProductDto productDto) throws Exception {
        Product product = ProductMapper.toEntity(productDto);
        List<Image> images = new ArrayList<>();

        String baseDir = System.getProperty("user.dir");
        String targetDir = baseDir + "/productsImages/";

        // Create the directory if it doesn't exist
        File directory = new File(targetDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        for (MultipartFile file : productDto.getImages()) {
            Path path = Paths.get(targetDir + file.getOriginalFilename());
            Files.write(path, file.getBytes());

            Image image = new Image();
            image.setUrl("/productsImages/" + file.getOriginalFilename());
            images.add(image);
        }

        product.setImage(images);
        return productRepository.save(product);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
