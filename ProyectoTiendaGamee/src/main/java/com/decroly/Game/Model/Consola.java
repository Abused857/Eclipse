package com.decroly.Game.Model;

import java.io.Serializable;

public class Consola extends Producto implements Serializable{
	
	private Plataforma plataforma;
	private boolean isNuevo;
	
	
	public Consola(String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion, Plataforma plataforma, boolean isNuevo) {
		
		
		
		super(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion);
		this.plataforma = plataforma;
		this.isNuevo = isNuevo;
		
		
	}


	public Plataforma getPlataforma() {
		return plataforma;
	}


	public boolean isNuevo() {
		return isNuevo;
	}
	
	
	
	public String toString() {
		
		
		return super.toString() + 
				"\nPlataforma: " + plataforma +
				"\nEs nuevo: " + isNuevo 
				;
	}
}
