package com.empresa.dominio.model.dto;

public class Persona {
	private String nombres;
	private String apellidos;
	private int edad;
	public Persona(String nombres, String apellidos, int i) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = i;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}		
}
