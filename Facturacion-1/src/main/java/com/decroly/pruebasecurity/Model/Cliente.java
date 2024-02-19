package com.decroly.pruebasecurity.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {
	
	@Id
	@Column (name = "nif", columnDefinition = "varchar(100) not null")
	private String nif;
	
	@Column (name = "nombre", columnDefinition = "varchar(100) not null")
	private String nombre;
	
	@Column (name = "direccion", columnDefinition = "varchar(100) null")
	private String direccion;
	
	@Column (name = "telefono", columnDefinition = "varchar(15) null")
	private String telefono;
	
	public Cliente()
	{
		
	}
	
	public Cliente(String nif, String nombre, String direccion, String telefono)
	{
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
