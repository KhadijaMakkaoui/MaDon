package com.madon.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.madon.demo.entity.CompagneFonds;
import com.madon.demo.entity.Donateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonsDTO {
    private Long id;
    private String ref;
    private Double montant;
    private Date date;
    private CompagneFonds compagneFonds;
    private Donateur donateur;
    static DonsDTO convertToDTO(DonsDTO donsDTO) {
        return new DonsDTO(
                donsDTO.getId(),
                donsDTO.getRef(),
                donsDTO.getMontant(),
                donsDTO.getDate(),
                donsDTO.getCompagneFonds(),
                donsDTO.getDonateur()
        );
    }
}





