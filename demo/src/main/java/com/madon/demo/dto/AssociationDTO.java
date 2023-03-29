package com.madon.demo.dto;

import com.madon.demo.entity.Association;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AssociationDTO {
    private Long id;
    private String ref;
    private String nom;
    private String adresse;
    private String description;
    private String imagePath;

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