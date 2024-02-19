package com.decroly.asla.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "pasajero")
public class Pasajero {
	
	@Id
	@Column (name = "id", columnDefinition = "binary(16) not null")
	private byte[] id;
	
	@Column (name = "nombre", columnDefinition = "varchar(100) not null")
	private String nombre;
	
	@Column (name = "apellido", columnDefinition = "varchar(100) not null")
	private String apellido;
	
	@Column (name = "edad", columnDefinition = "int(11) not null")
	private int edad;
	
	@Column (name = "correo_electronico	", columnDefinition = "varchar(100) not null")
	private String correoElectronico	;
	
	public Pasajero()
	{
		
	}
	
	public Pasajero(byte[] id, String nombre, String apellido, int edad, String correoElectronico)
	{
		this.id = id;
		this.nombre= nombre;
		this.apellido = apellido;
		this.edad= edad;
		this.correoElectronico = correoElectronico;
	}
	
	
	
	
}
	
	
	