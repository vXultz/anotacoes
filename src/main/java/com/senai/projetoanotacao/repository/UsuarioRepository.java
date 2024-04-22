package com.senai.projetoanotacao.repository;

import com.senai.projetoanotacao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByNomeUsuario(String nomeUsuario);
}
