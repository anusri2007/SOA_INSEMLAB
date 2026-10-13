
package com.example.auth;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    @PostMapping("/auth/login-static")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> input) {

        String username = input.get("username");
        String password = input.get("password");

        if (USERNAME.equals(username)
                && PASSWORD.equals(password)) {

            return ResponseEntity.ok(Map.of(
                "message", "Authentication Successful",
                "status", "200"
            ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of(
                    "message", "Authentication Failed",
                    "status", "401"
                ));
    }
}
