package com.senai.projetoanotacao.service;

import com.senai.projetoanotacao.entity.CadernoEntity;

import java.util.List;

public interface CadernoService {

    List<CadernoEntity> listarCadernos(CadernoEntity caderno);

    CadernoEntity buscarCadernoPorId(Long id) throws Exception;

    CadernoEntity criarCaderno(CadernoEntity caderno) throws Exception;

    CadernoEntity atualizarCaderno(Long id, CadernoEntity caderno) throws Exception;

    void deletarCaderno(Long id) throws Exception;
}

