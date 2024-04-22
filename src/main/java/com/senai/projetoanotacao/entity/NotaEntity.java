package com.senai.projetoanotacao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notas")
@Data
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "caderno_id")
    private CadernoEntity caderno;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    private String title;

    private String content;

}
