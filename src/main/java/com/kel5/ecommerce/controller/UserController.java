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

    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") long id) throws IOException, SQLException
    {
        Image image = imageService.viewById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("image/index");
        List<Image> imageList = imageService.viewAll();
        mv.addObject("imageList", imageList);
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView addImage(){
        return new ModelAndView("image/addimage");
    }

    @PostMapping("/add")
    public String addImagePost(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image image = new Image();
        image.setImage(blob);
        imageService.create(image);
        return "redirect:/user/";
    }
    
    @GetMapping("/")
    public ModelAndView DashboardAdmin(Model model) {
        ModelAndView mv = new ModelAndView("admin/index");
        return mv;
    }
    
    @GetMapping("/produk")
    public ModelAndView Produk(Model model) {
        return new ModelAndView("admin/produk");
    }

    @GetMapping("/pesanan")
    public ModelAndView Pesanan(Model model) {
        return new ModelAndView("admin/pesanan");
    }

//    @GetMapping("/artikel")
//    public ModelAndView Artikel(Model model) {
//        return new ModelAndView("admin/artikel");
//    }
    
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
        return new ModelAndView("admin/users-profile");
    }
    
}
