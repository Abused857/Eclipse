package com.decroly.asla.Model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "autobus")
public class Autobus {
	
	@Id
	@Column (name = "id", columnDefinition = "binary(16) not null")
	private byte[] id;
	
	@Column (name = "modelo", columnDefinition = "varchar(100) not null")
	private String modelo;
	
	@Column (name = "capacidad_pasajeros", columnDefinition = "int(11) not null")
	private int capacidadPasajeros;
	
	@Column (name = "placa", columnDefinition = "varchar(20) not null")
	private String placa;
	
	@Column (name = "color", columnDefinition = "varchar(50) not null")
	private String color;
	
	public Autobus()
	{
		
	}
	
	public Autobus(byte[] id, String modelo, int capacidadPasajeros, String placa, String color) {
        this.id = id;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.placa = placa;
        this.color = color;
    }
	
	public Autobus(UUID id, String modelo, int capacidadPasajeros, String placa, String color) {
        this.id = uuidToBytes(id); // Convierte el UUID a un arreglo de bytes
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.placa = placa;
        this.color = color;
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
