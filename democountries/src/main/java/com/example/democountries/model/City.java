package com.example.democountries.model;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


}
