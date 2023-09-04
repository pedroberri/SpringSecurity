package com.example.springsecurity.controller;

import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TesteController {

    private UsuarioRepository usuarioRepository;

//    @PostMapping
//    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        usuario.getPessoa().setSenha(encoder.encode(usuario.getPassword()));
//        return ResponseEntity.ok(usuarioRepository.save(usuario));
//    }

    @GetMapping("/teste")
    public ResponseEntity<String> getTeste() {
        return ResponseEntity.ok("Teste");
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/autenticado")
    public ResponseEntity<String> getAutenticado() {
        return ResponseEntity.ok("Autenticado");
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/autenticado/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Admin");
    }

    @GetMapping("/autenticado/vendedor")
    public ResponseEntity<String> getVendedor() {
        return ResponseEntity.ok("Vendedor");
    }

    @GetMapping("/autenticado/cliente")
    public ResponseEntity<String> getCliente() {
        return ResponseEntity.ok("Cliente");
    }

}
