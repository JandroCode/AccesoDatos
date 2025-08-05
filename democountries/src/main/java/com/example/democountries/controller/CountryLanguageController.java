package com.example.democountries.controller;

import com.example.democountries.DTO.countryLanguage.CountryLanguageDTO;
import com.example.democountries.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country-language")
public class CountryLanguageController {

    @Autowired
    private CountryLanguageService countryLanguageService;


    @PostMapping
    public ResponseEntity<?> insertLanguage(@RequestBody CountryLanguageDTO countryLanguageDTO){

        countryLanguageService.insert(
                countryLanguageDTO.getCountryCode(),
                countryLanguageDTO.getLanguage(),
                countryLanguageDTO.getIsOfficial(),
                countryLanguageDTO.getPercentage()
        );

        return ResponseEntity.ok(null);

    }
}
