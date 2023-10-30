package com.kel5.ecommerce.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cabang")
public class Cabang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namacabang;

    @Column(nullable = false)
    private String nomor;
    
    @Column(nullable = false)
    private String jalan;
    
    @Column(nullable = false)
    private String kecamatan;
    
    @Column(nullable = false)
    private String kabupaten;

    @Column(nullable = false)
    private String provinsi;
    
    @Column(nullable = false)
    private String telp;

    @Column(nullable = false)
    private String embeddedgmaps;
}
