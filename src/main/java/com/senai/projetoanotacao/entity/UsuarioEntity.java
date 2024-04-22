package com.senai.projetoanotacao.entity;

import com.senai.projetoanotacao.dto.request.LoginRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "usuarios")
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    @ManyToOne
    private PerfilEntity perfil;

    public boolean senhaValida(
            LoginRequest loginRequest,
            BCryptPasswordEncoder bCryptEncoder
    ) {
        return bCryptEncoder.matches(
                loginRequest.senha(),
                this.senha
        );
    }
}
