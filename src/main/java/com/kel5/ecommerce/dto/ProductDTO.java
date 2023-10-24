/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.dto;

import com.kel5.ecommerce.entity.Category;
import com.kel5.ecommerce.entity.Image;

import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String nama;
    private String deskripsi;
    private Long harga;
    private int stok;
    private double berat;
    private List<CategoryDTO> categories;
    private List<ImageDTO> images;
}