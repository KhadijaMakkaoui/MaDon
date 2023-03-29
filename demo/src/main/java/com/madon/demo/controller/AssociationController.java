package com.madon.demo.controller;

import com.madon.demo.dto.AssociationDTO;
import com.madon.demo.entity.Association;
import com.madon.demo.service.AssociationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/association")
@AllArgsConstructor
public class AssociationController {
    AssociationService associationService;
    AssociationDTO associationDTO;
    @GetMapping
    public List<AssociationDTO> getAllAssociation(){
        return associationService.getAllAssociation();
    }
    @PostMapping
    public Association createAssociation(@RequestBody Association association){
        return associationService.createAssociation(association);
    }
    @PostMapping("/update")
    public Association updateAssociation(Association association){
        return associationService.updateAssociation(association);
    }
    @PostMapping("/delete")
    public void deleteAssociation(Long id){
        associationService.deleteAssociation(id);
    }
}
