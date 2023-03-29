package com.madon.demo.dto;

import com.madon.demo.entity.Donateur;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DonateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String username;

    public static DonateurDTO convertToDTO(Donateur donateur) {
        return new DonateurDTO(
                donateur.getId(),
                donateur.getNom(),
                donateur.getPrenom(),
                donateur.getAdresse(),
                donateur.getTelephone(),
                donateur.getEmail(),
                donateur.getUsername()
        );
    }

}