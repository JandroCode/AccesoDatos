package com.example.RegistroYLoginConJwtTokens.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
    private String token;
}
