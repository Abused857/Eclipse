package com.decroly.Game.Model;

import java.io.Serializable;


public class VideoJuego extends Producto implements Serializable{
	
	private Genero genero;
	private Plataforma plataforma;
	private boolean isDigital;
	private boolean isNuevo;
	
	public VideoJuego (String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion, Genero genero, Plataforma plataforma, boolean isDigital, boolean isNuevo) {
		
		super(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion);
		this.genero = genero;
		this.plataforma = plataforma;
		this.isDigital = isDigital;
		this.isNuevo = isNuevo;
		
	}

	public Genero getGenero() {
		return genero;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public boolean isDigital() {
		return isDigital;
	}

	public boolean isNuevo() {
		return isNuevo;
	}
	
	
	@Override
	public String toString() {
	    return super.toString() + 
	    		"\nGenero: " + genero + 
	    		"\nPlataforma: " + plataforma +
	            "\nDigital: " + isDigital + 
	            "\nNuevo: " + isNuevo;
	}

}
