package com.example.springsecurity.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    private Long cpf;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

}
