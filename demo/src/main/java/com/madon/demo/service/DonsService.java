package com.madon.demo.service;

import com.madon.demo.dto.DonsDTO;
import com.madon.demo.entity.Dons;
import com.madon.demo.repository.DonsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class DonsService {
    private DonsRepo donsRepo;
    private DonsDTO donsDTO;
    public Dons createDons(Dons dons){
        return donsRepo.save(dons);
    }
    public Dons updateDons(Dons dons){
        return donsRepo.save(dons);
    }
    public void deleteDons(Long id){
        donsRepo.deleteById(id);
    }
    public DonsDTO getDons(Long id){

        return donsRepo.findById(id).stream().map((dons) -> donsDTO.convertToDTO(dons)).findFirst().get();
    }
    public List<DonsDTO> getAllDons(){
        return donsRepo.findAll()
                .stream()
                .map((dons) -> donsDTO.convertToDTO(dons))
                .collect(toList());
    }

}
