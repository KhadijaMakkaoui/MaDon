package com.madon.demo.service;

import com.madon.demo.entity.CompagneFonds;
import com.madon.demo.repository.CompagneFondsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompagneService {
    private CompagneFondsRepo compagneFondsRepo;
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
