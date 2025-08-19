package com.example.RegistroYLoginConJwtTokens.controller;

import com.example.RegistroYLoginConJwtTokens.dto.AuthRequestDTO;
import com.example.RegistroYLoginConJwtTokens.dto.AuthResponseDTO;
import com.example.RegistroYLoginConJwtTokens.dto.UserRequestDTO;
import com.example.RegistroYLoginConJwtTokens.dto.UserResponseDTO;
import com.example.RegistroYLoginConJwtTokens.service.UserDetailsServiceImpl;
import com.example.RegistroYLoginConJwtTokens.service.UserService;
import com.example.RegistroYLoginConJwtTokens.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO dto){
        UserResponseDTO userSaved = userService.save(dto);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
            String token = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(AuthResponseDTO.builder().token(token).build());

        }catch (AuthenticationException e){
            return ResponseEntity.status(401).build();
        }
    }




}
