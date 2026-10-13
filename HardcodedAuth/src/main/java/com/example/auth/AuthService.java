
package com.example.authservice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> input) {

        if (USERNAME.equals(input.get("username"))
                && PASSWORD.equals(input.get("password"))) {

            return ResponseEntity.ok(Map.of(
                "message", "Authentication Successful"
            ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of(
                    "message", "Authentication Failed"
                ));
    }
}
