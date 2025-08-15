package com.example.democountries.controller;

import com.example.democountries.DTO.city.CityDTO;
import com.example.democountries.DTO.city.PageCityResponse;
import com.example.democountries.DTO.country.CountryCityDTO;
import com.example.democountries.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    /*

        @GetMapping("/most-populated")
    public ResponseEntity<PageCityResponse> findMostPopulated(Pageable pageable){

        Page<CityDTO> page = cityService.getMostPopulated(pageable);

        PageCityResponse response = new PageCityResponse(
                page.getContent(),
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements()

        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



     */



    @GetMapping("/most-populated/{page}/{size}")
    public ResponseEntity<PageCityResponse> findMostPopulated(
            @PathVariable int page,
            @PathVariable int size){


        Pageable pageable = PageRequest.of(page-1, size);

        Page<CityDTO> cityPage = cityService.getMostPopulated(pageable);

        PageCityResponse response = new PageCityResponse(
                cityPage.getContent(),
                cityPage.getNumber(),
                cityPage.getTotalPages(),
                cityPage.getTotalElements()

        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<List<CountryCityDTO>> findByCountry(@PathVariable String name){
        return  ResponseEntity.ok(cityService.getByCountry(name));
    }


}
