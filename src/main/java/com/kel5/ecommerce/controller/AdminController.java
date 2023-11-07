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
import org.springframework.web.servlet.ModelAndView;

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
//
//    @GetMapping("/")
//    public String registrationForm(ModelMap model) {
//        String username = getLogedinUsername();
//        return "admin";
//    }
    
    @GetMapping("/")
    public ModelAndView DashboardAdmin(Model model) {
        ModelAndView mv = new ModelAndView("admin/index");
        return mv;
    }

    @GetMapping("/pesanan")
    public ModelAndView Pesanan(Model model) {
        return new ModelAndView("admin/pesanan");
    }

    @GetMapping("/pelanggan")
    public ModelAndView Pelanggan(Model model) {
        return new ModelAndView("admin/pelanggan");
    }
    
    @GetMapping("/pesanan/detail")
    public ModelAndView DetailPesanan(Model model) {
        return new ModelAndView("admin/rician_pesanan");
    }
    
    @GetMapping("/produk/detail")
    public ModelAndView DetailProduk(Model model) {
        return new ModelAndView("admin/rician_produk");
    }
    
    @GetMapping("/profil")
    public ModelAndView ViewProfile(Model model) {
        return new ModelAndView("admin/admins-profile");
    }
}
