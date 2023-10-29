package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Product;
import com.kel5.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // To display the form for adding a product
    @GetMapping("/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/addProduct";
    }

    // To handle the form submission
    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute ProductDto productDto, Model model) throws Exception {
        Product savedProduct = productService.saveProduct(productDto);
        model.addAttribute("message", "Product saved successfully");
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/Product";
    }


    @GetMapping("/products/view/{id}")
    public String viewProduct(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product/ProductDetail";
        } else {
            // Handle product not found scenario
            model.addAttribute("error", "Product not found");
            return "product/Product";
        }
    }
}