package com.example.democountries.repository;

import com.example.democountries.DTO.city.CityDTO;
import com.example.democountries.DTO.country.CountryCityDTO;
import com.example.democountries.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    // Lista de ciudades con población superior a la media
    @Query(value = """
                    SELECT id, name, population
                    FROM city
                    WHERE population > (SELECT AVG(population)
                    FROM city) ORDER BY population DESC
                    """, nativeQuery = true)
    Page<CityDTO> getMostPopulatedCities(Pageable pageable);


    // Lista de ciudades por País
    @Query(value = """
                        SELECT city.Name
                        FROM city INNER JOIN country ON city.CountryCode = country.Code
                        WHERE country.name = :name
                    """, nativeQuery = true)
    List<CountryCityDTO>getCitiesByCountry(@Param("name") String name);
}
