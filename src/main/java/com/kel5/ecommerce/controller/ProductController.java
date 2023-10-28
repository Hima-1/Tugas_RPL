package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Product;
import com.kel5.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    public String createProduct(@ModelAttribute ProductDto productDto, Model model) {
        try {
            Product savedProduct = productService.saveProduct(productDto);
            model.addAttribute("message", "Product saved successfully");
        } catch (Exception e) {
            model.addAttribute("message", "An error occurred while saving the product");
        }
        return "redirect:/products";
    }

    //To display the list of products
    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "product/Product"; // This should be the name of your Thymeleaf template for showing all products
    }

    // To display details of a single product
    @GetMapping("/view-product")
    public String viewProduct(Model model, Integer id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/viewProduct"; // This should be the name of your Thymeleaf template for showing a single product
    }
}
