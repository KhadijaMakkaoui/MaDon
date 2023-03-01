package com.madon.demo.entity;

import lombok.*;
import org.springframework.data.mapping.Association;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompagneFonds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    /*private Association association;*/


}
