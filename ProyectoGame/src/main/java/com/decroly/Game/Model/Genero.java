package com.decroly.Game.Model;

public enum Genero {

	accion("Genero de acción"),
	terror("Genero de terror"),
	aventura("Genero de aventura"),
	shotter("Genero de shotter"),
	estrategia("Genero de estrategia");
	
	
	
	private final String descripcion;
	
	Genero (String descripcion){
		
		this.descripcion = descripcion;	
		
	}
	
	 public String getDescripcion() {
	        return descripcion;
	    }

}