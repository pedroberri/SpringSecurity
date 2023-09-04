package com.example.springsecurity.security.util;

import com.example.springsecurity.model.entity.Pessoa;
import com.example.springsecurity.model.entity.Usuario;
import com.example.springsecurity.model.enums.Perfil;
import com.example.springsecurity.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BancoUtil {

    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void popularBanco() {
        usuarioRepository.deleteAll();

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(12345678900L);
        pessoa.setNome("Admin");
        pessoa.setSobrenome("do Sistema");
        pessoa.setEmail("adminstrador@gmail.com");
        pessoa.setSenha(new BCryptPasswordEncoder().encode("MI71"));

//        Usuario admin = new Usuario();
//        admin.setPessoa(pessoa);
//        admin.setAccountNonExpired(true);
//        admin.setAccountNonLocked(true);
//        admin.setCredentialsNonExpired(true);
//        admin.setEnabled(true);
//        admin.setAuthorities(List.of(Perfil.ADMIN));
//
//        Usuario vendedor = new Usuario();
//        vendedor.setPessoa(pessoa);
//        vendedor.setAccountNonExpired(true);
//        vendedor.setAccountNonLocked(true);
//        vendedor.setCredentialsNonExpired(true);
//        vendedor.setEnabled(true);
//        vendedor.setAuthorities(List.of(Perfil.VENDEDOR));
//
//        Usuario cliente = new Usuario();
//        cliente.setPessoa(pessoa);
//        cliente.setAccountNonExpired(true);
//        cliente.setAccountNonLocked(true);
//        cliente.setCredentialsNonExpired(true);
//        cliente.setEnabled(true);
//        cliente.setAuthorities(List.of(Perfil.CLIENTE));

        Usuario admin_vendedor = new Usuario();
        admin_vendedor.setPessoa(pessoa);
        admin_vendedor.setAccountNonExpired(true);
        admin_vendedor.setAccountNonLocked(true);
        admin_vendedor.setCredentialsNonExpired(true);
        admin_vendedor.setEnabled(true);
        admin_vendedor.setAuthorities(List.of(Perfil.ADMIN, Perfil.VENDEDOR));
        usuarioRepository.save(admin_vendedor);
    }

}
