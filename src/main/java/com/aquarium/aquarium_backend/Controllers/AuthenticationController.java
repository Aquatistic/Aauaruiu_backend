package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Security.AuthenticationRequest;
import com.aquarium.aquarium_backend.Security.AuthenticationResponse;
import com.aquarium.aquarium_backend.Security.ReqisterRequest;
import com.aquarium.aquarium_backend.Services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.registry.Registry;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.authenticate(request), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody ReqisterRequest request) {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

}
