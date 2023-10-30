package com.kel5.ecommerce.service.impl;

import com.kel5.ecommerce.dto.CabangDTO;
import com.kel5.ecommerce.entity.Cabang;
import com.kel5.ecommerce.mapper.CabangMapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kel5.ecommerce.service.CabangService;
import com.kel5.ecommerce.repository.CabangRepository;


@Service
public class CabangServiceImpl implements CabangService {

    @Autowired
    private CabangRepository repository;

    @Override
    public List<CabangDTO> getAll() {
        List<Cabang> cabangs = repository.findAll();
        List<CabangDTO> dtos = cabangs.stream()
            .map((student) -> (CabangMapper.mapToCabangDTO(student)))
            .collect(Collectors.toList());
        return dtos;
    }

//    @Override
//    public List<CabangDTO> search(String query) {
//        List<Cabang> students = repository.findByNimContainingOrNamaContaining(query, query);
//        List<CabangDTO> dtos = students.stream()
//            .map((student) -> (CabangMapper.mapToMahasiswaDTO(student)))
//            .collect(Collectors.toList());
//        
//        return dtos;
//    }

    @Override
    public void update(CabangDTO student) {
        repository.save(CabangMapper.mapToCabang(student));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(CabangDTO student) {
        repository.save(CabangMapper.mapToCabang(student));
    }

    @Override
    public CabangDTO findById(Long id) {
        Cabang mahasiswa = repository.findById(id).get();
        return CabangMapper.mapToCabangDTO(mahasiswa);
    }

    @Override
    public List<CabangDTO> search(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
