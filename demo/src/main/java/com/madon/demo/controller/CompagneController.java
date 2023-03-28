package com.madon.demo.controller;

import com.madon.demo.entity.CompagneFonds;
import com.madon.demo.service.CompagneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compagne")
@AllArgsConstructor
public class CompagneController {
    CompagneService compagneService;
    @GetMapping
    public void getCompagne(){
        compagneService.getAllCompagne();
    }
    @GetMapping("/id")
    public CompagneFonds getCompagneById(Long id){
       return compagneService.getCompagne(id);
    }
    @PostMapping
    public CompagneFonds createCompagne(CompagneFonds compagneFonds){
        return compagneService.createCompagne(compagneFonds);
    }
    @PostMapping("/update")
    public CompagneFonds updateCompagne(CompagneFonds compagneFonds){
        return compagneService.updateCompagne(compagneFonds);
    }
    @PostMapping("/id")
    public void deleteCompagne(Long id){
        compagneService.deleteCompagne(id);
    }
}
