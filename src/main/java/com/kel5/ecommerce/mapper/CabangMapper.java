package com.kel5.ecommerce.mapper;

import com.kel5.ecommerce.dto.CabangDTO;
import com.kel5.ecommerce.entity.Cabang;

/**
 * @author asus
 *         utility class berisi method static untuk
 *         mapping Entity ke Dto dan sebaliknya untuk Student.
 */
public class CabangMapper {
    // map Student entity to Student Dto
    public static CabangDTO mapToCabangDTO(Cabang cabang) {
        // Membuat dto dengan builder pattern (inject dari lombok)
        CabangDTO cabangDto = CabangDTO.builder()
                .id(cabang.getId())
                .namacabang(cabang.getNamacabang())
                .nomor(cabang.getNomor())
                .jalan(cabang.getJalan())
                .kecamatan(cabang.getKecamatan())
                .provinsi(cabang.getProvinsi())
                .telp(cabang.getTelp())
                .embeddedgmaps(cabang.getEmbeddedgmaps())
                .build();
        return cabangDto;
    }

    // map Student Dto ke Student Entity
    public static Cabang mapToCabang(CabangDTO cabangDTO) {
        Cabang cabang = Cabang.builder()
                .id(cabangDTO.getId())
                .namacabang(cabangDTO.getNamacabang())
                .nomor(cabangDTO.getNomor())
                .jalan(cabangDTO.getJalan())
                .kecamatan(cabangDTO.getKecamatan())
                .provinsi(cabangDTO.getProvinsi())
                .telp(cabangDTO.getTelp())
                .embeddedgmaps(cabangDTO.getEmbeddedgmaps())
                .build();
        return cabang;
    }
}
