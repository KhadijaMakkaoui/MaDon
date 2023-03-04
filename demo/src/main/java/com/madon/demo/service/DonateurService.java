package com.madon.demo.service;

import com.madon.demo.entity.Donateur;
import com.madon.demo.repository.DonateurRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DonateurService {
    private  DonateurRepository donateurRepository;

    private Donateur createDonateur(Donateur donateur){
        return donateurRepository.save(donateur);
    }
    private Donateur updateDonateur(Donateur donateur){
        return donateurRepository.save(donateur);
    }
    private void deleteDonateur(Long id){
        donateurRepository.deleteById(id);
    }

    private Donateur getDonateur(Long id){
        return donateurRepository.findById(id).get();
    }



}
