package com.aquarium.aquarium_backend.JwtConfig;

import com.aquarium.aquarium_backend.Repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class ApplicationConfig {
    private final UserRepository userRepository;

    ApplicationConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
    }
}
