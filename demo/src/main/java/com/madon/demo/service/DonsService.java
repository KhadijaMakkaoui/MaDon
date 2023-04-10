package com.madon.demo.service;

import com.madon.demo.dto.DonsDTO;
import com.madon.demo.entity.Dons;
import com.madon.demo.repository.DonsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class DonsService {
    private final DonsRepo donsRepo;
    private final CompagneService compagneFondsService;

    @Autowired
    public DonsService(DonsRepo donsRepo, CompagneService compagneFondsService) {
        this.donsRepo = donsRepo;
        this.compagneFondsService = compagneFondsService;
    }
    public Dons createDons(Dons dons,int compagneId){
        dons.setRef(UUID.randomUUID().toString());
        dons.setDate(new Date());
        dons.setCompagneFonds(compagneFondsService.getCompagne((long) compagneId));
        if(dons.getMontant()>0) {
            dons.getCompagneFonds().setMontantActuel((float) (dons.getCompagneFonds().getMontantActuel() + dons.getMontant()));
            compagneFondsService.updateCompagne(dons.getCompagneFonds());
            return donsRepo.save(dons);
        }
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
