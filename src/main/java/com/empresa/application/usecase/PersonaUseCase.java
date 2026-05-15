package com.empresa.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.application.port.in.PersonaPortIn;
import com.empresa.application.port.out.PersonaPortOut;
import com.empresa.dominio.model.dto.Persona;

@Service
public class PersonaUseCase implements PersonaPortIn{
	private final PersonaPortOut portOut;	
	
	public PersonaUseCase(PersonaPortOut portOut) {
		super();
		this.portOut = portOut;
	}

	@Override
	public List<Persona> listaPersonaMayores() {
		// TODO Auto-generated method stub
		List<Persona> personas = portOut.getPersona();
		return personas.stream()
			    .filter(p -> p.getEdad() >= 18)
			    .toList(); // o .collect(Collectors.toList()) si usas Java 8
	}

	
}