package com.example.springsecurity.security;

import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.security.util.CookieUtil;
import com.example.springsecurity.security.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class Filtro extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if(rotaPrivada(request.getRequestURI())) {
            try {
                String token = CookieUtil.getToken(request);
                Usuario usuario = JWTUtil.getUsuario(token);
                response.addCookie(CookieUtil.gerarCookie(usuario));
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                                usuario.getUsername(), null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                response.setStatus(401);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean rotaPrivada(String url) {
        return url.startsWith("/teste");
    }
}
