package com.empresa.infrastructure.list.adapter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.empresa.application.port.out.PersonaPortOut;
import com.empresa.dominio.model.dto.Persona;

import lombok.extern.slf4j.Slf4j;
@Slf4j
//@Component
public class ConsultaPersonaAdapter{/// implements PersonaPortOut{
//	@Override
	public List<Persona> getPersona() {
		// TODO Auto-generated method stub
		log.info("Consulta desde la Base de Datos Mysql");
		List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Carlos", "Perez", 25));
        personas.add(new Persona("Ana", "Gomez", 30));
        personas.add(new Persona("Luis", "Torres", 17));
        personas.add(new Persona("Maria", "Lopez", 40));
        personas.add(new Persona("Jorge", "Ramirez", 22));
        personas.add(new Persona("Laura", "Martinez", 19));
        personas.add(new Persona("Pedro", "Sanchez", 35));
        personas.add(new Persona("Sofia", "Castro", 28));
        personas.add(new Persona("Diego", "Morales", 15));
        personas.add(new Persona("Elena", "Vargas", 45));
        return personas;
	}
}
