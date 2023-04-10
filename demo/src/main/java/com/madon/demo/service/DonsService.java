package com.madon.demo.service;

import com.madon.demo.dto.DonsDTO;
import com.madon.demo.entity.Dons;
import com.madon.demo.repository.DonsRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class DonsService {
    private final DonsRepo donsRepo;

    @Autowired
    public DonsService(DonsRepo donsRepo) {
        this.donsRepo = donsRepo;
    }
    public Dons createDons(Dons dons){
        dons.setRef(UUID.randomUUID().toString());
        dons.setDate(new Date());
       /* double montant=double.parse(dons.getMontant());
        dons.setMontant(montant);*/
        if(dons.getMontant()>0)
            return donsRepo.save(dons);
        else
            return null;
    }
    public Dons updateDons(Dons dons){
        return donsRepo.save(dons);
    }
    public void deleteDons(Long id){
        donsRepo.deleteById(id);
    }
    public DonsDTO getDons(Long id){
        DonsDTO donsDTO=new DonsDTO();
        return donsRepo.findById(id).stream().map((dons) -> donsDTO.convertToDTO(dons)).findFirst().get();
    }
    public List<DonsDTO> getAllDons(){
        DonsDTO donsDTO=new DonsDTO();
        return donsRepo.findAll()
                .stream()
                .map((dons) -> donsDTO.convertToDTO(dons))
                .collect(toList());
    }

}
