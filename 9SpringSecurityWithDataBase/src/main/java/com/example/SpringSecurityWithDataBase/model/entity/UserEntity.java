package com.example.SpringSecurityWithDataBase.model.entity;

import com.example.SpringSecurityWithDataBase.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private  Boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;
}
