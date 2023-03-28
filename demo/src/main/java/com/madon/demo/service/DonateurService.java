package com.madon.demo.service;

import com.madon.demo.dto.DonateurDTO;
import com.madon.demo.entity.Donateur;
import com.madon.demo.repository.DonateurRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DonateurService {
    private  DonateurRepository donateurRepository;
    private DonateurDTO donateurDTO;

    public Donateur createDonateur(Donateur donateur){
        return donateurRepository.save(donateur);
    }
    public Donateur updateDonateur(Donateur donateur){
        return donateurRepository.save(donateur);
    }
    public void deleteDonateur(Long id){
        donateurRepository.deleteById(id);
    }

    public Donateur getDonateur(Long id){
        return donateurRepository.findById(id).get();
    }
    public List<DonateurDTO> getAllDonateur(){
        return donateurRepository.findAll().stream().map((donateur -> donateurDTO.convertToDTO(donateur))).collect(Collectors.toList());
    }



}
