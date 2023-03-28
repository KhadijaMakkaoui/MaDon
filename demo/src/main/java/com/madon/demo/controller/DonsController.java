package com.madon.demo.controller;

import com.madon.demo.dto.DonsDTO;
import com.madon.demo.entity.Dons;
import com.madon.demo.service.DonsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dons")
@AllArgsConstructor
public class DonsController {
    private DonsService donsService;
    @GetMapping
    public List<DonsDTO> getDons(){
        return donsService.getAllDons();
    }
    @GetMapping("/id")
    public DonsDTO getDonsById(Long id){
        return donsService.getDons(id);
    }
    @PostMapping
    public Dons createDons(Dons dons){
        return donsService.createDons(dons);
    }
    @PostMapping("/update")
    public Dons updateDons(Dons dons){
        return donsService.updateDons(dons);
    }
    @PostMapping("/delete")
    public void deleteDons(Long id){
        donsService.deleteDons(id);
    }


}
