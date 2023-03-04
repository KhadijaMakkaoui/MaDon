package com.madon.demo.dto;

import com.madon.demo.entity.Donateur;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String username;

    public static DonateurDTO fromEntity(Donateur donateur) {
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