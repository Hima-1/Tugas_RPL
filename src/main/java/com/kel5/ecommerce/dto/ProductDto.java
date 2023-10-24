/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.dto;

import com.kel5.ecommerce.entity.Image;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author pinaa
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    @NotEmpty(message = "ProductID should not be empty")
    private String productID;
    
    @NotEmpty(message = "Nama should not be empty")
    private String nama;
    
    @NotEmpty(message = "Deskripsi should not be empty")
    private String deskripsi;
    
    @NotNull (message = "Harga should not be empty")
    private double harga;
    
    @NotNull(message = "Nama should not be empty")
    private int stok;
    
    @NotNull (message = "Berat should not be empty")
    private double berat;
    
    private List<Image> image;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedOn;   
}