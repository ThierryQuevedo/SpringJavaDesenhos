package com.desenho.cadastro_desenho.controller;

import com.desenho.cadastro_desenho.business.DesenhoService;
import com.desenho.cadastro_desenho.infrastrucure.entitys.Desenho;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desenho")
@RequiredArgsConstructor

public class DesenhoController {
    private final DesenhoService desenhoService;

    @PostMapping
    public ResponseEntity<Void> salvarDesenho(@RequestBody Desenho desenho){
        desenhoService.salvarDesenho(desenho);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Desenho> buscarDesenhosPorNome(@RequestParam String nome){
        return ResponseEntity.ok(desenhoService.buscarDesenhoPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarDesenhoPorNome(@RequestParam String nome){
        desenhoService.deletarDesenhoPorNome(nome);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    public ResponseEntity<Void> atualizarDesenhoPorId(@RequestBody Desenho desenho, @RequestParam Integer id){
        desenhoService.atualizarDesenhoPorId(id, desenho);
        return ResponseEntity.ok().build();
    }
}