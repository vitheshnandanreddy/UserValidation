package com.SpringBoot.Signin_Signup;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;  // Inject your EmailService

    public String register(User user) {
        userRepository.save(user);

        // Send registration email
        try {
            emailService.sendRegistrationEmail(user.getEmail());
            System.out.println("Email sent to " + user.getEmail());
        } catch (Exception e) {
            System.err.println("Error sending registration email: " + e.getMessage());
        }

        return "Registered successfully";
    }

    public User authenticate(String identifier, String password) {
        return userRepository.findByEmailOrPhone(identifier, identifier)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }

    public Optional<User> findByIdentifier(String identifier) {
        return userRepository.findByEmailOrPhone(identifier, identifier);
    }
}
