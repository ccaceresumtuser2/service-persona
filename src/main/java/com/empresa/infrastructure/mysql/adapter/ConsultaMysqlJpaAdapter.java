package com.empresa.infrastructure.mysql.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.empresa.application.port.out.PersonaPortOut;
import com.empresa.dominio.model.dto.Persona;
import com.empresa.infrastructure.persistence.repository.PersonaRepository;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class ConsultaMysqlJpaAdapter implements PersonaPortOut{

	private final PersonaRepository repository;
	
	
	public ConsultaMysqlJpaAdapter(PersonaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Persona> getPersona() {
		log.info("JPA MYSQL ADAPTER");
		return repository.findAll()
			   .stream()
			   .map(e->new Persona(e.getNombre(),e.getApellido(),e.getEdad()))
			   .collect(Collectors.toList());
	}	
}