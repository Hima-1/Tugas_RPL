/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.entity.Announcement;
import com.kel5.ecommerce.service.AnnouncementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AnnouncementController {
    
    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/announcements") // Ganti "RequestMapping" menjadi "GetMapping" untuk mendapatkan daftar pengumuman
    public String getAllAnnouncements(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Announcement> listAnnouncement = announcementService.getAllAnnouncement(keyword);
        model.addAttribute("listAnnouncement", listAnnouncement);
        model.addAttribute("keyword", keyword);
        return "announcements";
    }

    @GetMapping("/showNewAnnouncementForm") // Ganti "Project2" menjadi "showNewAnnouncementForm"
    public String showNewAnnouncementForm(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "announcement_add";
    }

    @PostMapping("/saveAnnouncement") // Metode POST untuk menyimpan pengumuman
    public String saveAnnouncement(@ModelAttribute("announcement") Announcement announcement, Model model) {
        try {
            Announcement saveAnnouncement = announcementService.saveAnnouncement(announcement);
            model.addAttribute("message", "Announcement saved successfully");
        } catch (Exception e) {
            model.addAttribute("error", "Error saving announcement: " + e.getMessage());
        }

        return "redirect:/announcements"; // Redirect ke halaman daftar pengumuman
    }

    @GetMapping("/showAnnouncementFormForUpdate/{id}")
    public String showAnnouncementFormForUpdate(@PathVariable("id") long id, Model model) {
        Announcement announcement = announcementService.getAnnouncementById(id);
        model.addAttribute("announcement", announcement);
        return "announcement_edit";
    }

    @GetMapping("/deleteAnnouncement/{id}") 
    public String deleteAnnouncement(@PathVariable("id") long id) {
        announcementService.deleteAnnouncementById(id);
        return "redirect:/announcements";
    }
    
}
