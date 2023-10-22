package com.decroly.Game.Model;

import java.io.Serializable;

public class Perifericos extends Producto implements Serializable {
	
	
	private TipoDispositivo tipoDispositivo;
	private boolean isNuevo;
	private boolean isWireless;
	private String marca;
	
	
	public Perifericos (String nombre, String serialNumber, String descripcion, int precio,
						long fechaLanzamiento, String edicion, TipoDispositivo tipoDispositivo, boolean isNuevo,
						boolean isWireless, String marca) 
	
	{
		
		super(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion);
		this.tipoDispositivo = tipoDispositivo;
		this.isNuevo = isNuevo;
		this.isWireless = isWireless;
		this.marca = marca;
	
	}


	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}


	public boolean isNuevo() {
		return isNuevo;
	}


	public boolean isWireless() {
		return isWireless;
	}


	public String getMarca() {
		return marca;
	}
	
	@Override
	public String toString() {
		
		return super.toString()	 +
				"\nNuevo: " + isNuevo +
				"\nWireless: " + isWireless +
				"\nMarca: " + marca
				;

	}
	
	
	
	
	

}
