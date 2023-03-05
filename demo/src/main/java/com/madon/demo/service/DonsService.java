package com.madon.demo.service;

import com.madon.demo.entity.Dons;
import com.madon.demo.repository.DonsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DonsService {
    private DonsRepo donsRepo;
    public Dons createDons(Dons dons){
        return donsRepo.save(dons);
    }
    public Dons updateDons(Dons dons){
        return donsRepo.save(dons);
    }
    public void deleteDons(Long id){
        donsRepo.deleteById(id);
    }
    public Dons getDons(Long id){
        return donsRepo.findById(id).get();
    }

}
