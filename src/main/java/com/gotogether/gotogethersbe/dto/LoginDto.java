package com.gotogether.gotogethersbe.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDto {

    @Data
    @Builder
    public static class LoginRequest {
        private String email;
        private String password;

        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(email, password);
        }
    }
}
