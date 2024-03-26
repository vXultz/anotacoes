package com.senai.projetoanotacao.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String senha;

}
