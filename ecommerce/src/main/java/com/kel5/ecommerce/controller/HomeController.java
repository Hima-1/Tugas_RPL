/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.entity.Product;
import com.kel5.ecommerce.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pinaa
 */

@Controller
public class HomeController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public String home () {
        return "user/index";
    }
    
//    @GetMapping("/shop")
//    public String shop(){
//        return "user/shop";
//    }    
    
//    @GetMapping("/shop-detail")
//    public String shopDetail(){
//        return "user/shop-detail";
//    }    
    
    @GetMapping("/about")
    public String about(){
        return "user/about";
    }    
    
    @GetMapping("/contact-us")
    public String contactUs(){
        return "user/contact-us";
    }    
    
    @GetMapping("/my-account")
    public String myAccount(){
        return "user/my-account";
    }    
    
    @GetMapping("/service")
    public String service(){
        return "user/service";
    }    
    
    @GetMapping("/wishlist")
    public String wishlist(){
        return "user/wishlist";
    }    
    
    @GetMapping("/products/view/{id}")
    public String viewProduct(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "user/shop-detail";
        } else {
            // Handle product not found scenario
            model.addAttribute("error", "Product not found");
            return "product/Product";
        }
    }
    
    @GetMapping("/shop")
    public String Project1(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Product> listProduct = productService.getAllProduct(keyword);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("keyword", keyword);
        return "user/shop";
    }
}
