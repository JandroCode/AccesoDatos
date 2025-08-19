package com.example.RegistroYLoginConJwtTokens.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String username;
    private String role;
}
