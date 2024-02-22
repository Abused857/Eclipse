package com.example.Dawnesa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cine")
public class Cine 
{

	@Id
	@Column (name = "cod_cine", columnDefinition = "varchar(10) not null")
	private String codCine;
	
	@Column (name = "direccion", columnDefinition = "varchar(100) not null")
	private String direccion;
	
	@Column (name = "telefono", columnDefinition = "varchar(9) not null")
	private String telefono;
	
	@Column (name = "e-mail", columnDefinition = "varchar(45) not null")
	private String email;
	
	@Column (name = "horario", columnDefinition = "varchar(100) not null")
	private String horario;
	
	public Cine()
	{
		
	}
	
	public Cine(String codCine, String direccion, String telefono, String email, String horario)
	{
		this.codCine = codCine;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.horario = horario;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the codCine
	 */
	public String getCodCine() {
		return codCine;
	}
	
}
