package com.decroly.asla.Model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "reserva")
public class Reserva {
	
	@Id
	@Column (name = "id", columnDefinition = "binary(16) not null")
	private byte[] id;
	
	@ManyToOne
	@JoinColumn (name = "id_ticket", columnDefinition = "binary(16)  not null")
	private Ticket idTicket;
	
	@ManyToOne
	@JoinColumn (name = "id_pasajero", columnDefinition = "binary(16)  not null")
	private Pasajero idPasajero;
	
	@Column(name = "numero_asiento", columnDefinition = "int(11) not null")
	private int numeroAsiento;
	
	@Column (name = "estado", columnDefinition = "varchar(20) not null")
	private String estado;


	

	
	public Reserva()
	{
		
	}
	
	public Reserva(byte[] id, Ticket idTicket, Pasajero idPasajero, int numeroAsiento, String estado) {
	    this.id = id;
	    this.idTicket = idTicket;
	    this.idPasajero = idPasajero;
	    this.numeroAsiento = numeroAsiento;
	    this.estado = estado;
	}
}