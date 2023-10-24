/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kel5.ecommerce.repository;

import com.kel5.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pinaa
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
