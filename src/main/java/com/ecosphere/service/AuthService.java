package com.ecosphere.service;

import com.ecosphere.model.User;
import com.ecosphere.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public Map<String, Object> register(String fullName, String email, String password, String role, String schoolName) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User(fullName, email, passwordEncoder.encode(password), role, schoolName);
        userRepository.save(user);
        String token = jwtService.generateToken(email, role);

        return Map.of(
            "token", token,
            "user", Map.of(
                "fullName", fullName,
                "email", email,
                "role", role,
                "schoolName", schoolName
            )
        );
    }

    public Map<String, Object> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPasswordHash())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        User user = userOpt.get();
        String token = jwtService.generateToken(email, user.getRole());

        return Map.of(
            "token", token,
            "user", Map.of(
                "fullName", user.getFullName(),
                "email", user.getEmail(),
                "role", user.getRole(),
                "schoolName", user.getSchoolName()
            )
        );
    }
}
