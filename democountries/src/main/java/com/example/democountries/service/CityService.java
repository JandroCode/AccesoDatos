package com.example.democountries.service;

import com.example.democountries.DTO.city.CityDTO;
import com.example.democountries.DTO.country.CountryCityDTO;
import com.example.democountries.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Page<CityDTO> getMostPopulated(Pageable pageable){
        return cityRepository.getMostPopulatedCities(pageable);
    }

    public List<CountryCityDTO> getByCountry(String name){
        return cityRepository.getCitiesByCountry(name);
    }


}
