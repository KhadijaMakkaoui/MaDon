package com.madon.demo.controller;

import com.madon.demo.dto.DonateurDTO;
import com.madon.demo.service.DonateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/donateur")
@AllArgsConstructor
public class DonateurController {
    DonateurService donateurService;
    @GetMapping
    public List<DonateurDTO> getAllDonateur(){
        return donateurService.getAllDonateur();
    }

}
