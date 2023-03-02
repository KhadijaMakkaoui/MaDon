package com.madon.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Double montant;
    private Date date;
    @ManyToOne
    private CompagneFonds compagneFonds;
    @ManyToOne
    private Donateur donateur;
}
