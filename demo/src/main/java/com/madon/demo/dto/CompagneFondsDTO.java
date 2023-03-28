package com.madon.demo.dto;

import com.madon.demo.entity.Association;
import com.madon.demo.entity.CompagneFonds;
import com.madon.demo.entity.Dons;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompagneFondsDTO {
    private Long id;
    private String ref;
    private String titre;
    private String description;
    private String imagePath;
    private Date dateDebut;
    private Date dateFin;
    private Float montantObjectif;
    private Float montantActuel;
    private int nbBeneficiaire;
    private Association association;
    private List<Dons> dons;
    public static CompagneFondsDTO convertToDTO(CompagneFonds compagneFonds) {
        return new CompagneFondsDTO(
                compagneFonds.getId(),
                compagneFonds.getRef(),
                compagneFonds.getTitre(),
                compagneFonds.getDescription(),
                compagneFonds.getImagePath(),
                compagneFonds.getDateDebut(),
                compagneFonds.getDateFin(),
                compagneFonds.getMontantObjectif(),
                compagneFonds.getMontantActuel(),
                compagneFonds.getNbBeneficiaire(),
                compagneFonds.getAssociation(),
                compagneFonds.getDons()
        );
    }
}
