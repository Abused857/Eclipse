package com.decroly.asla.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "ruta")
public class Ruta {
	
	@Id
	@Column (name = "id", columnDefinition = "binary(16) not null")
	private byte[] id;
	
	@Column (name = "origen", columnDefinition = "varchar(100) not null")
	private String origen;
	
	@Column (name = "destino", columnDefinition = "varchar(100) not null")
	private String destino;
	
	@Column (name = "distancia_km", columnDefinition = "decimal(10,2) not null")
	private BigDecimal distanciaKm;
	

	
	public Ruta()
	{
		
	}
	
	 public Ruta(byte[] id, String origen, String destino, BigDecimal distanciaKm) {
	        this.id = id;
	        this.origen = origen;
	        this.destino = destino;
	        this.distanciaKm = distanciaKm;
	    }
	
	

}
