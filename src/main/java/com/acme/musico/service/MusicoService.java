package com.acme.musico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.musico.model.Musico;

@Service
public interface MusicoService {

    Musico create(Musico musico);

    Optional<Musico> findById(Long id);

    List<Musico> findAll();

    void deleteById(Long id);

    Musico update(Musico musico);
}
