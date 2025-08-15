package com.example.democountries.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countryLanguage" )
public class CountryLanguage {


    @Id
    @Column(name = "CountryCode")
    private String countryCode;
}
