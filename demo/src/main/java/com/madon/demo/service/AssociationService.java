package com.madon.demo.service;

import com.madon.demo.dto.AssociationDTO;
import com.madon.demo.entity.Association;
import com.madon.demo.repository.AssociationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AssociationService {
    private AssociationRepo associationRepo;
    private AssociationDTO associationDTO;

    public Association createAssociation(Association association){
        return associationRepo.save(association);
    }
    public Association updateAssociation(Association association){
        return associationRepo.save(association);
    }
    public void deleteAssociation(Long id){
        associationRepo.deleteById(id);
    }
    public Association getAssociation(Long id){
        return associationRepo.findById(id).get();
    }

    public Association getAssociationByRef(String ref){
        return associationRepo.findByRef(ref);
    }


    public List<AssociationDTO> getAllAssociation() {
        return associationRepo.findAll().stream().map((association -> new AssociationDTO())).collect(java.util.stream.Collectors.toList());
    }
}
