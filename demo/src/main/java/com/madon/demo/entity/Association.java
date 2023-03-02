package com.madon.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String nom;
    private String adresse;
    private String description;
    private String imagePath;
    @OneToMany(mappedBy = "association",fetch = FetchType.LAZY)
    private List<CompagneFonds> listCompagnes;




}
