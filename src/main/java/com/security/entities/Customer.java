package com.security.entities;

import com.security.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "users")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
