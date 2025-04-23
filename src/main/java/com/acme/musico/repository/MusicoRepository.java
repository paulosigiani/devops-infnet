package com.acme.musico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.musico.model.Musico;

public interface MusicoRepository extends JpaRepository<Musico, Long> {

}