package com.madon.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @ManyToOne
    private Association association;
    @JsonIgnore
    @OneToMany(mappedBy = "compagneFonds",fetch = FetchType.LAZY)
    private List<Dons> dons;


}
