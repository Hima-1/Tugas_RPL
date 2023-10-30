package com.kel5.ecommerce.service;

import com.kel5.ecommerce.dto.CabangDTO;
import java.util.List;


public interface CabangService {
    List<CabangDTO> getAll();
    List<CabangDTO> search(String query);
    void update(CabangDTO cabang);
    void delete(Long id);
    void save(CabangDTO cabang);
    CabangDTO findById(Long id);
}
