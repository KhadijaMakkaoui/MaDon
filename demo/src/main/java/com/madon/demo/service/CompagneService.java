package com.madon.demo.service;

import com.madon.demo.dto.CompagneFondsDTO;
import com.madon.demo.entity.CompagneFonds;
import com.madon.demo.repository.CompagneFondsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompagneService {
    private CompagneFondsRepo compagneFondsRepo;
    private CompagneFondsDTO compagneFondsDTO;
    public List<CompagneFondsDTO> getAllCompagne(){
        return compagneFondsRepo.findAll().stream().map((compagneFonds -> compagneFondsDTO.convertToDTO(compagneFonds))).collect(Collectors.toList());
    }
    public CompagneFonds createCompagne(CompagneFonds compagneFonds){
        return compagneFondsRepo.save(compagneFonds);
    }
    public CompagneFonds updateCompagne(CompagneFonds compagneFonds){
        return compagneFondsRepo.save(compagneFonds);
    }
    public void deleteCompagne(Long id){
        compagneFondsRepo.deleteById(id);
    }
    public CompagneFonds getCompagne(Long id){
        return compagneFondsRepo.findById(id).get();
    }



}
