package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

    private String getLogedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/")
    public String registrationForm(ModelMap model) {
        String username = getLogedinUsername();
        return "admin";
    }
    
    @GetMapping("/dashboard")
    public String DashboardAdmin(Model model) {
        return "admin/dashboard";
    }
    
    @GetMapping("/produk")
    public String Produk(Model model) {
        return "admin/produk";
    }

    @GetMapping("/pesanan")
    public String Pesanan(Model model) {
        return "admin/pesanan";
    }

    @GetMapping("/artikel")
    public String Artikel(Model model) {
        return "admin/artikel";
    }
}
