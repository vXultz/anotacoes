package com.senai.projetoanotacao.service;

import com.senai.projetoanotacao.entity.CadernoEntity;
import com.senai.projetoanotacao.repository.CadernoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadernoServiceImpl implements CadernoService{

    private final CadernoRepository cadernoRepository;

    public CadernoServiceImpl(CadernoRepository cadernoRepository) {
        this.cadernoRepository = cadernoRepository;
    }

    @Override
    public List<CadernoEntity> listarCadernos(CadernoEntity caderno) {
        return cadernoRepository.findAll();
    }

    @Override
    public CadernoEntity buscarCadernoPorId(Long id) throws Exception {
        return cadernoRepository.findById(id).orElseThrow();
    }

    @Override
    public CadernoEntity criarCaderno(CadernoEntity caderno) throws Exception {
        caderno.setId(null);
        return cadernoRepository.save(caderno);
    }

    @Override
    public CadernoEntity atualizarCaderno(Long id, CadernoEntity caderno) throws Exception {
        CadernoEntity entity =buscarCadernoPorId(id);
        entity.setNome(caderno.getNome());
        return cadernoRepository.save(entity);
    }

    @Override
    public void deletarCaderno(Long id) throws Exception {
        CadernoEntity entity = buscarCadernoPorId(id);
        cadernoRepository.delete(entity);
    }
}
