package com.example.springsecurity.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springsecurity.model.entity.Usuario;

import java.util.Date;

public class JWTUtil {

    private static String secret = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";

    public static String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("WEG")
                .withSubject(usuario.getUsername())
                .withIssuedAt(new Date()) //Data da emissão
                .withExpiresAt(new Date(new Date().getTime()+60*30))
                .sign(Algorithm.HMAC256(secret));
    }
}
