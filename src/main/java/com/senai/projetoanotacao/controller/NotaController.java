package com.senai.projetoanotacao.controller;

import com.senai.projetoanotacao.entity.NotaEntity;
import com.senai.projetoanotacao.service.NotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {
    
    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<NotaEntity>> get(NotaEntity nota) {
        List<NotaEntity> notas = service.listarNotas(nota);
        return ResponseEntity.status(HttpStatus.OK).body(notas);
    }

    @GetMapping("{id}")
    public NotaEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarNotaPorId(id);
    }

    @PostMapping
    public ResponseEntity<NotaEntity> post(@RequestBody NotaEntity nota) throws Exception {
        NotaEntity notas = service.criarNota(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(notas);
    }

    @PutMapping("{id}")
    public ResponseEntity<NotaEntity> post(@PathVariable Long id, @RequestBody NotaEntity nota) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarNota(id, nota));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.deletarNota(id);
        return ResponseEntity.noContent().build();
    }
}
