package com.example.democountries.service;

import com.example.democountries.repository.CountryLanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryLanguageService {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;


    @Transactional
    public void insert(String countryCode, String language, String isOfficial, Double percentage){
        countryLanguageRepository.insertLanguage(countryCode, language, isOfficial, percentage);
    }
}
