/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.entity.Cabang;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kel5.ecommerce.repository.CabangRepository;

@Controller
public class CabangController {
    @Autowired
    private CabangRepository cabangRepository;

    @GetMapping("/")
    public String listCabang(Model model) {
        List<Cabang> cabangs = cabangRepository.findAll();
        model.addAttribute("cabangs", cabangs);
        return "listMenu";
    }

    @GetMapping("/add")
    public String addCabangForm(Cabang cabang) {
        return "addMenu";
    }

    @PostMapping("/add")
    public String addCabang(@Valid Cabang cabang, BindingResult result) {
        if (result.hasErrors()) {
            return "addMenu";
        }
        cabangRepository.save(cabang);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCabangForm(@PathVariable("id") Long id, Model model) {
        Cabang cabang = cabangRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Cabang Id: " + id));
        model.addAttribute("cabang", cabang);
        return "editMenu";
    }

    @GetMapping("/detail/{id}")
    public String detailCabang(@PathVariable("id") Long id, Model model) {
        Cabang cabang = cabangRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Cabang Id: " + id));
        model.addAttribute("cabang", cabang);
        return "detailMenu";
    }

    @PostMapping("/edit/{id}")
    public String editCabang(@PathVariable("id") Long id, @Valid Cabang cabang, BindingResult result) {
        if (result.hasErrors()) {
            cabang.setId(id);
            return "editMenu";
        }
        cabangRepository.save(cabang);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCabang(@PathVariable("id") Long id) {
        Cabang cabang = cabangRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Cabang Id: " + id));
        cabangRepository.delete(cabang);
        return "redirect:/";
    }

//    @GetMapping("/search")
//    public String searchMahasiswa(@RequestParam(name = "query") String query, Model model) {
//        List<Cabang> cabangs = cabangRepository.findByNimContainingOrNamaContaining(query, query);
//
//        if (mahasiswas.isEmpty()) {
//            model.addAttribute("message", "Tidak ditemukan mahasiswa dengan NIM atau nama tersebut.");
//            return "searchResult";
//        } else {
//            if (mahasiswas.size() == 1) {
//                Long id = mahasiswas.get(0).getId();
//                return "redirect:/detail/" + id;
//            }
//            model.addAttribute("mahasiswas", mahasiswas);
//            return "searchResult";
//        }
//    }

}
