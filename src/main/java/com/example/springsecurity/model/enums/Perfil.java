package com.example.springsecurity.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Perfil implements GrantedAuthority {

    ADMIN,
    VENDEDOR,
    CLIENTE;

    @Override
    public String getAuthority() {
        return name();
    }
}
