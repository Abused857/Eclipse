package com.decroly.Game.Model;

import java.io.Serializable;

public class Producto implements Serializable{

	private int id;
	private String serialNumber;
	private String nombre;
	private String descripcion;
	//me di cuenta tarde de que puse int, es double obviamente, pero bueno
	//mi tienda no acepta centimos
	private int precio;
	private long fechaLanzamiento;
	private String edicion;
	private static int cont;
	
	
	public Producto(String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion) {
		
		cont++;
		this.id = cont;
		
		this.serialNumber = serialNumber;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaLanzamiento = fechaLanzamiento;
		this.edicion = edicion;

	}


	public int getId() {
		return id;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public int getPrecio() {
		return precio;
	}



	public long getFechaLanzamiento() {
		return fechaLanzamiento;
	}


	public String getEdicion() {
		return edicion;
	}


	public static int getCont() {
		return cont;
	}
	public void setCont(int i) {
		this.cont = i;
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	private void setPrecio(int precio) {
		this.precio = precio;
	}



	private void setFechaLanzamiento(long fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}


	private void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	
	@Override
	public String toString() {
		
		return 	"\n"+
				"\nProducto con id: " + id +
				"\nNumero de serie: " + serialNumber +
				"\nNombre: " + nombre +
				"\nDescripción: " + descripcion +
				"\nPrecio: " + precio +
				"\nFecha de lanzamiento: " + fechaLanzamiento +
				"\nEdicion" + edicion 
				
				;
	}
	
	
	
	
}
