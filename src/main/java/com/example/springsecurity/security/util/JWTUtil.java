package com.example.springsecurity.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static String secret = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";

    private static UsuarioRepository usuarioRepository;

    @Autowired
    public JWTUtil(UsuarioRepository usuarioRepository) {
        JWTUtil.usuarioRepository = usuarioRepository;
    }

    public static String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("WEG")
                .withSubject(usuario.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(new Date().getTime()+60*30))
                .sign(Algorithm.HMAC256(secret));
    }

    public static Usuario getUsuario(String token) {
        String username = JWT.decode(token).getSubject();
        return usuarioRepository.findByPessoa_Nome(username).orElseThrow(RuntimeException::new);
    }
}
