package com.acme.musico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.musico.model.Musico;
import com.acme.musico.service.MusicoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class MusicoController {

    private final MusicoService musicoService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(musicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Find Instrumento by ID {}", id);
        Optional<Musico> optMusico = musicoService.findById(id);
        if (optMusico.isPresent()) {
            return ResponseEntity.ok(optMusico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        musicoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Musico musico) {
        Musico created = musicoService.create(musico);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Musico musico) {
        musicoService.update(musico);
        return ResponseEntity.ok().build();
    }
}
