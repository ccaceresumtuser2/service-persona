package com.empresa.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.application.port.in.PersonaPortIn;
import com.empresa.dominio.model.dto.Persona;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/persona")
@CrossOrigin("*")
@Tag(name = "Personas", description = "API de gestión de personas")
public class PersonaController {
	private final PersonaPortIn portIn;

	public PersonaController(PersonaPortIn portIn) {
		super();
		this.portIn = portIn;
	}
	@GetMapping("/mayoredad")
    @Operation(
		        summary = "Listar personas mayores de edad",
		        description = "Obtiene una lista de personas cuya edad es mayor o igual a 18 años"
		    )
		    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
		    @ApiResponse(responseCode = "204", description = "No hay personas mayores de edad")
		    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	public ResponseEntity<List<Persona>> getPersona(){
		List<Persona> personas = portIn.listaPersonaMayores();
		if (personas.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
		return ResponseEntity.ok(personas);
	}
}