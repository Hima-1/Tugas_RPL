package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.entity.Blog;
import com.kel5.ecommerce.entity.Image;
import com.kel5.ecommerce.entity.User;
import com.kel5.ecommerce.service.BlogService;
import com.kel5.ecommerce.service.ImageService;
import com.kel5.ecommerce.service.UserService;
import com.kel5.ecommerce.util.FileUploadUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes("name")
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

    private String getLogedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    
    @GetMapping("/")
    public String userHome(ModelMap model){
        String username = getLogedinUsername();
        return "user/index";
    } 
    
    @GetMapping("/shop")
    public String shop(ModelMap model){
        String username = getLogedinUsername();
        return "user/shop";
    }    
    
    @GetMapping("/shop-detail")
    public String shopDetail(ModelMap model){
        String username = getLogedinUsername();
        return "user/shop-detail";
    }    
    
    @GetMapping("/about")
    public String about(ModelMap model){
        String username = getLogedinUsername();
        return "user/about";
    }    
    
    @GetMapping("/cart")
    public String cart(ModelMap model){
        String username = getLogedinUsername();
        return "user/cart";
    }    
    
    @GetMapping("/checkout")
    public String checkout(ModelMap model){
        String username = getLogedinUsername();
        return "user/checkout";
    }    
    
    @GetMapping("/contact-us")
    public String contactUs(ModelMap model){
        String username = getLogedinUsername();
        return "user/contact-us";
    }    
    
    @GetMapping("/my-account")
    public String myAccount(ModelMap model){
        String username = getLogedinUsername();
        return "user/my-account";
    }    
    
    @GetMapping("/service")
    public String service(ModelMap model){
        String username = getLogedinUsername();
        return "user/service";
    }    
    
    @GetMapping("/wishlist")
    public String wishlist(ModelMap model){
        String username = getLogedinUsername();
        return "user/wishlist";
    }
}
