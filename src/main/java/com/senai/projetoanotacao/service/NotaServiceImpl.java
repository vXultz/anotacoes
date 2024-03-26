package com.senai.projetoanotacao.service;

import com.senai.projetoanotacao.entity.NotaEntity;
import com.senai.projetoanotacao.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService{
    
    private final NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Override
    public List<NotaEntity> listarNotas(NotaEntity nota) {
        return notaRepository.findAll();
    }

    @Override
    public NotaEntity buscarNotaPorId(Long id) throws Exception {
        return notaRepository.findById(id).orElseThrow();
    }

    @Override
    public NotaEntity criarNota(NotaEntity nota) throws Exception {
        nota.setId(null);
        return notaRepository.save(nota);
    }

    @Override
    public NotaEntity atualizarNota(Long id, NotaEntity nota) throws Exception {
        NotaEntity entity =buscarNotaPorId(id);
        entity.setCaderno(nota.getCaderno());
        entity.setUsuario(nota.getUsuario());
        entity.setTitle(nota.getTitle());
        entity.setContent(nota.getContent());
        return notaRepository.save(entity);
    }

    @Override
    public void deletarNota(Long id) throws Exception {
        NotaEntity entity = buscarNotaPorId(id);
        notaRepository.delete(entity);
    }
}
