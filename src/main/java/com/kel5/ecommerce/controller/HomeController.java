/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author pinaa
 */

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home () {
        return "user/index";
    }
    
    @GetMapping("/index")
    public String index () {
        return "user/index";
    }
    
    @GetMapping("/shop")
    public String shop(){
        return "user/shop";
    }    
    
    @GetMapping("/shop-detail")
    public String shopDetail(){
        return "user/shop-detail";
    }    
    
    @GetMapping("/about")
    public String about(){
        return "user/about";
    }    
    
    @GetMapping("/cart")
    public String cart(){
        return "user/cart";
    }    
    
    @GetMapping("/checkout")
    public String checkout(){
        return "user/checkout";
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
}
