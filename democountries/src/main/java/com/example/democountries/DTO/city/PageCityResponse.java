package com.example.democountries.DTO.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCityResponse {
    private List<CityDTO> cities;
    private int currentPage;
    private  int totalPages;
    private long totalElements;
}
