package com.senai.projetoanotacao.service;

import com.senai.projetoanotacao.entity.NotaEntity;

import java.util.List;

public interface NotaService {

    List<NotaEntity> listarNotas(NotaEntity nota);

    NotaEntity buscarNotaPorId(Long id) throws Exception;

    NotaEntity criarNota(NotaEntity nota) throws Exception;

    NotaEntity atualizarNota(Long id, NotaEntity nota) throws Exception;

    void deletarNota(Long id) throws Exception;
}
