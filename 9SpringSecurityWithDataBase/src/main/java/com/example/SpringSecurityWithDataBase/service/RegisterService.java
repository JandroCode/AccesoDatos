package com.example.SpringSecurityWithDataBase.service;

import com.example.SpringSecurityWithDataBase.dto.RegisterDTO;
import com.example.SpringSecurityWithDataBase.model.entity.UserEntity;
import com.example.SpringSecurityWithDataBase.model.enums.Role;
import com.example.SpringSecurityWithDataBase.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final  PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterDTO dto){
        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);

        user.setRole(Role.valueOf("ROLE_"+dto.getRole().toUpperCase()));

        userRepository.save(user);

    }
}
