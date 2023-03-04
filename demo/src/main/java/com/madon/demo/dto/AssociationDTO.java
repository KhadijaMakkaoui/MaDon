package com.madon.demo.dto;

import com.madon.demo.entity.Association;
import lombok.Data;

@Data
public class AssociationDTO {
    private Long id;
    private String ref;
    private String nom;
    private String adresse;
    private String description;
    private String imagePath;

    public AssociationDTO() {}

    public AssociationDTO(Long id, String ref, String nom, String adresse, String description, String imagePath) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.imagePath = imagePath;
    }

    public static AssociationDTO convertToDTO(Association association) {
        return new AssociationDTO(
                association.getId(),
                association.getRef(),
                association.getNom(),
                association.getAdresse(),
                association.getDescription(),
                association.getImagePath()
        );
    }
}