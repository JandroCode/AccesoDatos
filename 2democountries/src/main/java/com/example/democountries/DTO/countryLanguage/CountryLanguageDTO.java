package com.example.democountries.DTO.countryLanguage;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguageDTO {

    private String countryCode;
    private String language;
    private String isOfficial;
    private Double percentage;
}
