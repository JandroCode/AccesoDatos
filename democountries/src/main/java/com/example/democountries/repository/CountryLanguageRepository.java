package com.example.democountries.repository;

import com.example.democountries.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {

    @Modifying
    @Query(value = "INSERT INTO countrylanguage VALUES(:countryCode, :language, :isOfficial, :percentage);" ,nativeQuery = true)
    void insertLanguage(
            @Param("countryCode") String countryCode,
            @Param("isOfficial") String isOfficial,
            @Param("language") String language,
            @Param("percentage") Double percentage

    );

}
