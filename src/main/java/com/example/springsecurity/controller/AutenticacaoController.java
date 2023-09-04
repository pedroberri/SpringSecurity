package com.example.springsecurity.controller;

import com.example.springsecurity.model.entity.Login;
import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.security.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Login login,
            HttpServletRequest request,
            HttpServletResponse response ) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(), login.getPassword());

        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            Cookie cookie = CookieUtil.gerarCookie((Usuario) authentication.getPrincipal());
            response.addCookie(cookie);
            return ResponseEntity.ok(authentication.getPrincipal());
        }

        return ResponseEntity.status(401).build();
    }

}
