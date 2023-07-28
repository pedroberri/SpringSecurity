package com.example.springsecurity.controller;

import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/teste")
public class TesteController {

    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping("/1")
    public ResponseEntity<String> get1() {
        return ResponseEntity.ok("1");
    }

    @GetMapping("/2")
    public ResponseEntity<String> get2() {
        return ResponseEntity.ok("2");
    }


}
