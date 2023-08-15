package com.example.springsecurity.security.service;

import com.example.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        return usuarioRepository.findByPessoa_Nome(nome)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
