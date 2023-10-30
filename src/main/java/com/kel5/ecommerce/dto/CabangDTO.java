package com.kel5.ecommerce.dto;

import jakarta.persistence.Column;
import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CabangDTO {
    private Long id;

    @NotEmpty(message ="Nama Cabang Tidak Boleh Kosong!")
    private String namacabang;
   
    
    @NotEmpty(message = "Nomor Tidak Boleh Kosong!")
    private String nomor;
    
    @NotEmpty(message = "Jalan Tidak Boleh Kosong!")
    private String jalan;
    
    @NotEmpty(message = "Kecamatan Tidak Boleh Kosong!")
    private String kecamatan;

    @NotEmpty(message = "Kabupaten Tidak Boleh Kosong!")
    private String kabupaten;
    
    @NotEmpty(message = "Provinsi Tidak Boleh Kosong!")
    private String provinsi;
    
    @NotEmpty(message = "telp Tidak Boleh Kosong!")
    private String telp;
    
    @NotEmpty(message = "GMaps Tidak Boleh Kosong!")
    private String embeddedgmaps;
   
}
