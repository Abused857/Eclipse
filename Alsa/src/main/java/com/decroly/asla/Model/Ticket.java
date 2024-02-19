package com.decroly.asla.Model;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "ticket")
public class Ticket {
	
	@Id
	@Column (name = "id", columnDefinition = "binary(16) not null")
	private byte[] id;
	
	@ManyToOne
	@JoinColumn (name = "id_autobus", columnDefinition = "binary(16)  not null")
	private Autobus idAutobus;
	
	@ManyToOne
	@JoinColumn (name = "id_ruta", columnDefinition = "binary(16)  not null")
	private Ruta idRuta;
	
	@Column(name = "fecha_viaje", columnDefinition = "Date not null")
	private Date fechaViaje;
	
	@Column (name = "precio", columnDefinition = "decimal(10,2) not null")
	private BigDecimal precio;


	

	
	public Ticket()
	{
		
	}
	
	public Ticket(byte[] id, Autobus idAutobus, Ruta idRuta, Date fechaViaje, BigDecimal precio) {
	    this.id = id;
	    this.idAutobus = idAutobus;
	    this.idRuta = idRuta;
	    this.fechaViaje = fechaViaje;
	    this.precio = precio;
	}
	public Ticket(UUID id, Autobus idAutobus, Ruta idRuta, Date fechaViaje, BigDecimal precio) {
        this.id = uuidToBytes(id); // Convierte el UUID a un arreglo de bytes
        this.idAutobus = idAutobus;
        this.idRuta = idRuta;
        this.fechaViaje = fechaViaje;
        this.precio = precio;
    }
	private byte[] uuidToBytes(UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (msb >>> 8 * (7 - i));
        }
        for (int i = 8; i < 16; i++) {
            buffer[i] = (byte) (lsb >>> 8 * (7 - i));
        }
        return buffer;
    }

	
	
	
	

}
