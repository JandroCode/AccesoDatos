package com.example.democountries.controller;

import com.example.democountries.DTO.country.CountryDTO;
import com.example.democountries.DTO.country.CountryLanguageDTO;
import com.example.democountries.DTO.country.CountrySimpleDTO;
import com.example.democountries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    private ResponseEntity<List<CountryDTO>>  list(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{continent}")
    private ResponseEntity<List<CountrySimpleDTO>>  listByContinent(@PathVariable String continent){
        return new ResponseEntity<>(countryService.getByContinent(continent), HttpStatus.OK);
    }

    @GetMapping("/greater-than/{name}")
    private ResponseEntity<List<CountryDTO>>  listGreaterThan(@PathVariable String name){
        return new ResponseEntity<>(countryService.getGreaterThan(name), HttpStatus.OK);
    }

    @GetMapping("/greater-than-min-population/{minPopulation}")
    private ResponseEntity<List<CountryDTO>>  listGreaterThanMinPopulation(@PathVariable Integer minPopulation){
        return new ResponseEntity<>(countryService.getByMinPopulation(minPopulation),HttpStatus.OK);
    }

    @GetMapping("/more-than-three-official-language")
    private ResponseEntity<List<CountryLanguageDTO>>  listMoreThanThreeOfficialLanguages(){
        return new ResponseEntity<>(countryService.getMoreThanThreeOfficialLanguages(),HttpStatus.OK);
    }




}
