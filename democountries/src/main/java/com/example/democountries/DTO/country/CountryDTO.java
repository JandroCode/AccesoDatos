package com.example.democountries.DTO.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private String code;
    private String name;
    private String continent;
    private Integer population;

}
