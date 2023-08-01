package com.example.springsecurity.security.util;

import com.example.springsecurity.model.entity.Pessoa;
import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class BancoUtil {

    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void popularBanco() {
        usuarioRepository.deleteAll();

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(12345678900L);
        pessoa.setNome("Administrador");
        pessoa.setSobrenome("do Sistema");
        pessoa.setEmail("adminstrador@gmail.com");
        pessoa.setSenha(new BCryptPasswordEncoder().encode("MI71"));

        Usuario usuario = new Usuario();
        usuario.setPessoa(pessoa);
        usuario.setAccountNonExpired(true);
        usuario.setAccountNonLocked(true);
        usuario.setCredentialsNonExpired(true);
        usuario.setEnabled(true);
        usuario.setAuthorities(new ArrayList<>());
        usuarioRepository.save(usuario);
    }

}
