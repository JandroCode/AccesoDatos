package com.example.democountries.DTO.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguageDTO {

    private String code;
    private String name;
    private String continent;
}
