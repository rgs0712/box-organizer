package br.com.rgs.boxorganizer.controller;

import br.com.rgs.boxorganizer.dto.LoginRequest;
import br.com.rgs.boxorganizer.dto.LoginResponse;
import br.com.rgs.boxorganizer.entities.User;
import br.com.rgs.boxorganizer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
public class TokenController {

    @Value("${jwt.token.expiresIn:3000}")
    private Long expiresIn;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

        Optional<User> opUser = userRepository.findByUserName(loginRequest.user());
        if(opUser.isEmpty() || !opUser.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("user or password is invalid!");
        }

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("box-organizer")
                .subject(opUser.get().getUserId().toString())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .build();

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(accessToken, expiresIn));
    }

}
