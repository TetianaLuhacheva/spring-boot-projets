package fr.tetiana.chain_prof.controller; 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


//import com.projets_profesionels.v01.dto.AuthenticationResponse;
//import com.projets_profesionels.v01.dto.LoginRequest;
import com.projets_profesionels.v01.dto.RefreshTokenRequest;
import com.projets_profesionels.v01.dto.RegisterRequest;
import com.projets_profesionels.v01.service.AuthService;
import com.projets_profesionels.v01.service.RefreshTokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthController {           // <- O.o - lié à RegisterRequest.java

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) { 
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                OK);
    } 

}
