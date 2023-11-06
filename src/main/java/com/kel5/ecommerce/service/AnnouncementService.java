/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kel5.ecommerce.service;

import com.kel5.ecommerce.entity.Announcement;

import java.util.List;



/**
 *
 * @author HP
 */
public interface AnnouncementService {

    Announcement saveAnnouncement(Announcement announcement);
    Announcement getAnnouncementById(long id);
    
    void deleteAnnouncementById(long id);
    List<Announcement> getAllAnnouncement(String keyword);
    
    
}
