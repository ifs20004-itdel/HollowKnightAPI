package com.artefact.HollowKnight.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hero_table")
public
class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String heroId;

//    @Column(name = "name")
    private String name;

//    @Column(name = "photoUrl")
    private String photoUrl;

//    @Column(name = "gender" )
    private String gender;
}
