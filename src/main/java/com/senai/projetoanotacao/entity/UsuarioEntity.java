package com.senai.projetoanotacao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
public class UsuarioEntity {

    @Id
    private Long id;

    private String nome;

    private String senha;

}
