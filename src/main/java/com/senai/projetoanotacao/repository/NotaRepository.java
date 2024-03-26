package com.senai.projetoanotacao.repository;

import com.senai.projetoanotacao.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
}
