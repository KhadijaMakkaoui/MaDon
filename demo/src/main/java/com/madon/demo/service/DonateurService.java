package com.madon.demo.service;

import com.madon.demo.entity.Donateur;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String username;

    public static DonateurDto fromEntity(Donateur donateur) {
        return new DonateurDto(
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