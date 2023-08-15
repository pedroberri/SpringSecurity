package com.example.springsecurity.security.util;

import com.example.springsecurity.model.entity.Usuario;
import jakarta.servlet.http.Cookie;

public class CookieUtil {

    public static Cookie gerarCookie(Usuario usuario) {
        String token = JWTUtil.gerarToken(usuario);
        Cookie cookie = new Cookie("JWT", token);
        cookie.setPath("/");
        cookie.setMaxAge(1800);
        return cookie;
    }
}
