/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.service.ProductService;
import com.kel5.ecommerce.dto.ProductDto;
import com.kel5.ecommerce.entity.Image;
import com.kel5.ecommerce.repository.ImageRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pinaa
 */

@Controller
public class ProductController {
    private ProductService productService;
    
    public ProductController (ProductService productService){
        this.productService = productService;
    }
    
    @Autowired
    private ImageRepository imageRepository;
    
    @GetMapping("/products")
    public String products(Model model){
        List<ProductDto> productDtos = this.productService.showData();
        model.addAttribute("productDtos", productDtos);
        return "/products";
    }
    
    @GetMapping("/products/add")
    public String addProductForm(Model model){
        ProductDto productDto = new ProductDto();
        List<Image> listImages = imageRepository.findAll();
        model.addAttribute("listImages", listImages);
        model.addAttribute("ProductDto", productDto);
        return "/products_add_form";
    }
    
    @PostMapping("/products/add/save")
    public String addProduct(@Valid ProductDto productDto, BindingResult result){
        if(result.hasErrors()){
            return "/products_add_form";
        }
        productService.saveData(productDto);
        return "redirect:/products/add?success";
    }
    
    @GetMapping("/products/{productId}/update")
    public String updateProduct (@PathVariable("productId") Long pdtId, Model model) {
        ProductDto pdtDto = productService.findProductById(pdtId);
        List<Image> listImages = imageRepository.findAll();
        model.addAttribute("listImages", listImages);
        model.addAttribute("productDto", pdtDto);
        return "products_update_form";
    }
    
    @PostMapping("/products/update")
    public String updateProducts (@Valid ProductDto pdtDto, BindingResult result){
        if(result.hasErrors()){
            return "/products_update_form";
        }
        productService.updateData(pdtDto);
        return "redirect:/products";
    }
    
    @GetMapping("/products/{productId}/delete")
    public String deleteProduct(@PathVariable("productId") Long pdtId){
        productService.deleteData(pdtId);
        return "redirect:/products";
    }
    
}
