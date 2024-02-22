package com.example.Dawnesa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {
	
	@Id
	@Column (name = "nif", columnDefinition = "varchar(10) not null")
	private String codCliente;
	
	@Column (name = "nombre", columnDefinition = "varchar(100) not null")
	private String nombre;
	
	@Column (name = "direccion", columnDefinition = "varchar(100) null")
	private String direccion;
	
	@Column (name = "telefono", columnDefinition = "varchar(15) null")
	private String telefono;
	
	public Cliente(String codCliente, String nombre, String direccion, String telefono)
	{
		this.codCliente = codCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		
	}
	
	public Cliente()
	{
		
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
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
