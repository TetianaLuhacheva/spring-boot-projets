package fr.tetiana.chain_prof.service;

import fr.tetiana.chain_prof.dto.RegisterRequest;
import fr.tetiana.chain_prof.model.User;

import fr.tetiana.chain_prof.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.tetiana.chain_prof.repository.VerificationTokenRepository;
import fr.tetiana.chain_prof.model.NotificationEmail;
import fr.tetiana.chain_prof.model.VerificationToken;

import lombok.AllArgsConstructor;

import java.time.Instant;
import javax.transaction.Transactional;
// import static org.springframework.http.HttpStatus.OK;


//import com.projets_profesionels.v01.dto.AuthenticationResponse;
//import com.projets_profesionels.v01.dto.LoginRequest;
//import com.projets_profesionels.v01.dto.RefreshTokenRequest;
//import com.projets_profesionels.v01.exceptions.SpringRedditException;
//import com.projets_profesionels.v01.security.JwtProvider;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;

//import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {                                  // <- O.o - signUp + Generation mot de pass

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;             // <- O.o - import com...repository.UserRepository
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());                     // <- O.o -import java.time.Instant;
        user.setEnabled(false);

        userRepository.save(user);
        
        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }
}
