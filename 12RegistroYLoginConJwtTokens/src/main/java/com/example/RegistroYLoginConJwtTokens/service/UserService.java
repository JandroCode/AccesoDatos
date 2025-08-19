package com.example.RegistroYLoginConJwtTokens.service;

import com.example.RegistroYLoginConJwtTokens.dto.UserRequestDTO;
import com.example.RegistroYLoginConJwtTokens.dto.UserResponseDTO;
import com.example.RegistroYLoginConJwtTokens.model.entity.UserEntity;
import com.example.RegistroYLoginConJwtTokens.model.enums.Role;
import com.example.RegistroYLoginConJwtTokens.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository usuarioRepository, PasswordEncoder passwordEncoder ){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO save(UserRequestDTO dto){

        UserEntity user = UserEntity.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole() != null ? Role.valueOf(dto.getRole()) : Role.ROLE_USER)
                .build();

        UserEntity userSaved = usuarioRepository.save(user);

        return UserResponseDTO.builder()
                .username(userSaved.getUsername())
                .role(userSaved.getRole().name())
                .build();

    }

    public UserResponseDTO findByUsername(String username){
        UserEntity user = usuarioRepository
                .findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));

        return UserResponseDTO.builder()
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();

    }








}
