package com.example.Dawnesa.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "sesiones")
public class Sesiones {
	
	@Id
	@Column (name = "id", columnDefinition = "int(11) not null")
	private int id;
	
	@Column (name = "is_vose", columnDefinition = "tinyint(1) null")
	private boolean isVose;
	
	@Column (name = "is_dto", columnDefinition = "tiniyint(1) null")
	private boolean isDto;
	
	
	@Column (name = "fecha_hora", columnDefinition = "bigint(20) not null")
	private long fecha;
	
	@ManyToOne
	@JoinColumn (name = "isan", columnDefinition = "varchar(45)  null")
	private Peliculas isan;
	
	@ManyToOne
	@JoinColumn (name = "cod_sala", columnDefinition = "varchar(20) not null")
	private Sala codSala;
	
	public Sesiones () 
	
	{
		
	}
	
public Sesiones (int id, boolean isVose, boolean isDto, long fecha, Peliculas isan, Sala codSala) 
	
	{
	
		this.id = id;
		this.isVose = isVose;
		this.isDto = isDto;
		this.fecha = fecha;
		this.isan = isan;
		this.codSala = codSala;
	
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public boolean isVose() {
	return isVose;
}

public void setVose(boolean isVose) {
	this.isVose = isVose;
}

public boolean isDto() {
	return isDto;
}

public void setDto(boolean isDto) {
	this.isDto = isDto;
}

public long getFecha() {
	return fecha;
}

public void setFecha(long fecha) {
	this.fecha = fecha;
}

public Peliculas getIsan() {
	return isan;
}

public void setIsan(Peliculas isan) {
	this.isan = isan;
}

public Sala getCodSala() {
	return codSala;
}

public void setCodSala(Sala codSala) {
	this.codSala = codSala;
}




	
		
















































	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
