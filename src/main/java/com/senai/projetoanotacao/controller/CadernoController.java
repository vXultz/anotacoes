package com.senai.projetoanotacao.controller;

import com.senai.projetoanotacao.entity.CadernoEntity;
import com.senai.projetoanotacao.service.CadernoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadernos")
public class CadernoController {

    private final CadernoService service;

    public CadernoController(CadernoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CadernoEntity>> get(CadernoEntity caderno) {
        List<CadernoEntity> cadernos = service.listarCadernos(caderno);
        return ResponseEntity.status(HttpStatus.OK).body(cadernos);
    }

    @GetMapping("{id}")
    public CadernoEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarCadernoPorId(id);
    }

    @PostMapping
    public ResponseEntity<CadernoEntity> post(@RequestBody CadernoEntity caderno) throws Exception {
        CadernoEntity cadernos = service.criarCaderno(caderno);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadernos);
    }

    @PutMapping("{id}")
    public ResponseEntity<CadernoEntity> post(@PathVariable Long id, @RequestBody CadernoEntity caderno) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarCaderno(id, caderno));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.deletarCaderno(id);
        return ResponseEntity.noContent().build();
    }
}
