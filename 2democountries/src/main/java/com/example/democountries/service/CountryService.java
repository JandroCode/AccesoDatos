package com.example.democountries.service;

import com.example.democountries.DTO.country.CountryDTO;
import com.example.democountries.DTO.country.CountryLanguageDTO;
import com.example.democountries.DTO.country.CountrySimpleDTO;
import com.example.democountries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public List<CountryDTO> getAll(){
        return countryRepository.getTopFiveMostPopulatedCountries();
    }

    public List<CountrySimpleDTO> getByContinent(String name){
        return countryRepository.getCountriesByContinent(name);
    }

    public List<CountryDTO> getGreaterThan(String name){
        return countryRepository.getCountriesGreaterThan(name);
    }

    public List<CountryDTO> getByMinPopulation(Integer minPopulation){
        return countryRepository.getCountriesGreaterThanMinPopulation(minPopulation);
    }


    public List<CountryLanguageDTO> getMoreThanThreeOfficialLanguages(){
        return countryRepository.getCountriesMoreThanThreeOfficialLanguages();
    }



}
