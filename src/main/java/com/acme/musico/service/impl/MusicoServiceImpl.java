package com.acme.musico.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.musico.model.Musico;
import com.acme.musico.repository.MusicoRepository;
import com.acme.musico.service.MusicoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicoServiceImpl implements MusicoService {

    private final MusicoRepository musicoRepository;

    @Override
    public Musico create(Musico musico) {
        return musicoRepository.save(musico);
    }

    @Override
    public Optional<Musico> findById(Long id) {
        return musicoRepository.findById(id);
    }

    @Override
    public List<Musico> findAll() {
        return musicoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        musicoRepository.deleteById(id);
    }

    @Override
    public Musico update(Musico musico) {
        return musicoRepository.save(musico);
    }

}
