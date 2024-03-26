package com.senai.projetoanotacao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cadernos")
@Data
public class CadernoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
