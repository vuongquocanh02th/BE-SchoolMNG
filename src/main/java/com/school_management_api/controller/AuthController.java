package com.school_management_api.controller;

import com.school_management_api.model.DTO.UserDTO;
import com.school_management_api.model.User;
import com.school_management_api.service.security.JWTService;
import com.school_management_api.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final IUserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO dto) {
        userService.registerNewUser(dto); // ✅ gọi method mới
        return ResponseEntity.ok("Đăng ký thành công");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto) {
        System.out.println("➡ Đăng nhập với: " + dto.getUsername() + " / " + dto.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );

            System.out.println("✅ Xác thực thành công: " + authentication.isAuthenticated());

            String token = jwtService.generateToken(dto.getUsername());
            return ResponseEntity.ok(token);

        } catch (Exception e) {
            System.err.println("❌ Đăng nhập thất bại: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Đăng nhập thất bại: " + e.getMessage());
        }
    }
}

