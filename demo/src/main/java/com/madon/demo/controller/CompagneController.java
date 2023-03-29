package com.madon.demo.controller;

import com.madon.demo.dto.CompagneFondsDTO;
import com.madon.demo.entity.CompagneFonds;
import com.madon.demo.service.CompagneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/compagne")
@AllArgsConstructor
public class CompagneController {
    CompagneService compagneService;
    @GetMapping
    public List<CompagneFondsDTO> getCompagne(){
        return compagneService.getAllCompagne();
    }
    @GetMapping("/id")
    public CompagneFonds getCompagneById(Long id){
       return compagneService.getCompagne(id);
    }
    @PostMapping
    public CompagneFonds createCompagne(@RequestBody CompagneFonds compagneFonds){
        return compagneService.createCompagne(compagneFonds);
    }
    @PostMapping("/update")
    public CompagneFonds updateCompagne(@RequestBody CompagneFonds compagneFonds){
        return compagneService.updateCompagne(compagneFonds);
    }
    @PostMapping("/id")
    public void deleteCompagne(@PathVariable Long id){
        compagneService.deleteCompagne(id);
    }
}
