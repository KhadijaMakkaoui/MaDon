package com.madon.demo.service;

import com.madon.demo.dto.AssociationDTO;
import com.madon.demo.entity.Association;
import com.madon.demo.repository.AssociationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AssociationService {
    @Autowired
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
/*public List<Association> getAllAssociation(){
        return associationRepo.findAll();
    }*/

    public List<AssociationDTO> getAllAssociation() {
        return associationRepo.findAll().stream().map((association -> associationDTO.convertToDTO(association))).collect(Collectors.toList());
    }
}
