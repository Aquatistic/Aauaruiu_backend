package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.Security.AuthenticationRequest;
import com.aquarium.aquarium_backend.Security.AuthenticationResponse;
import com.aquarium.aquarium_backend.Security.ReqisterRequest;
import com.aquarium.aquarium_backend.databaseTables.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
    }

    public AuthenticationResponse register(ReqisterRequest request) {
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);

    }
}
