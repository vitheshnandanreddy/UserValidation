package com.SpringBoot.Signin_Signup;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.register(user);
        emailService.sendRegistrationEmail(user.getEmail());
        return ResponseEntity.ok("Registered Successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> creds) {
        String identifier = creds.get("identifier");
        String password = creds.get("password");

        User user = userService.authenticate(identifier, password);
        if (user != null)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> payload) {
        String identifier = payload.get("identifier");
        String newPassword = payload.get("newPassword");

        Optional<User> userOpt = userService.findByIdentifier(identifier);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPassword(newPassword);
            userService.register(user);
            return ResponseEntity.ok("Password reset successful");
        }
        return ResponseEntity.badRequest().body("User not found");
    }
}
