package com.example.springsecurity.security.util;

import com.example.springsecurity.model.entity.Usuario;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.util.WebUtils;

import java.util.Objects;

public class CookieUtil {

    public static Cookie gerarCookie(Usuario usuario) {
        String token = JWTUtil.gerarToken(usuario);
        Cookie cookie = new Cookie("JWT", token);
        cookie.setPath("/");
        cookie.setMaxAge(1800);
        return cookie;
    }

    public static String getToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "JWT");
        if (cookie != null) {
            return cookie.getValue();
        }
        throw new RuntimeException("Token não encontrado");
    }
}
