package fr.tetiana.chain_prof.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {                      // <- O.o - lié à AuthController.java
    private String email;
    private String username;
    private String password;
} 
