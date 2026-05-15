package com.empresa.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.infrastructure.persistence.entity.PersonaEntity;


public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
