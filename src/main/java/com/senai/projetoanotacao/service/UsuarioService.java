package com.senai.projetoanotacao.service;

import com.senai.projetoanotacao.dto.request.InserirUsuarioRequest;
import com.senai.projetoanotacao.entity.UsuarioEntity;
import com.senai.projetoanotacao.repository.PerfilRepository;
import com.senai.projetoanotacao.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final BCryptPasswordEncoder bCryptEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public void cadastraNovoUsuario(
            @RequestBody InserirUsuarioRequest inserirUsuarioRequest
    ) {
        boolean usuarioExsite = usuarioRepository
                .findByNomeUsuario(inserirUsuarioRequest.nomeUsuario())
                .isPresent();

        if (usuarioExsite) {
            throw new RuntimeException("Usuario já existe");
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(inserirUsuarioRequest.nomeUsuario());
        usuario.setSenha(
                bCryptEncoder.encode(inserirUsuarioRequest.senha())
        );
        usuario.setPerfil(
                perfilRepository.findByNome(inserirUsuarioRequest.nomePerfil())
                        .orElseThrow(() -> new RuntimeException("Perfil inválido ou inexistente"))
        );

        usuarioRepository.save(usuario);
    }
}
