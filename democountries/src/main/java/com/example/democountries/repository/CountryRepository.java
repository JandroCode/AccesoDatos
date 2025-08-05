package com.example.democountries.repository;

import com.example.democountries.DTO.country.CountryDTO;
import com.example.democountries.DTO.country.CountryLanguageDTO;
import com.example.democountries.DTO.country.CountrySimpleDTO;
import com.example.democountries.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Devolver los 5 países más poblados
    @Query(value = "SELECT code, name, continent, population FROM country ORDER BY population DESC LIMIT 5" ,nativeQuery = true)
    List<CountryDTO> getTopFiveMostPopulatedCountries();

    // Listar los países que pertenecen a un continente especificado
    @Query(value = "SELECT code, name, continent  FROM country WHERE continent = :continent" ,nativeQuery = true)
    List<CountrySimpleDTO> getCountriesByContinent(@Param("continent") String continent);

    // Listar los países que tienen una poblaciòn mayor a la de un país pasado por parámetro
    @Query(value = "SELECT code, name, continent, population  FROM country WHERE population > (SELECT population FROM country WHERE name = :name)" ,nativeQuery = true)
    List<CountryDTO> getCountriesGreaterThan(@Param("name") String name);


    // Listar los países que tienen una poblaciòn mayor a la de un valor pasado por parámetro
    @Query(value = "SELECT code, name, continent, population  FROM country WHERE population > :minPopulation" ,nativeQuery = true)
    List<CountryDTO> getCountriesGreaterThanMinPopulation(@Param("minPopulation") int minPopulation);

    // Listar los países que tienen un número de idiomas oficiales mayor de tres
    @Query(value = "SELECT code, name, continent FROM country WHERE (SELECT COUNT(*) FROM countryLanguage " +
            "WHERE countryLanguage.countryCode = country.code AND countryLanguage.IsOfficial = 'T')>3" ,nativeQuery = true)
    List<CountryLanguageDTO> getCountriesMoreThanThreeOfficialLanguages();






}
