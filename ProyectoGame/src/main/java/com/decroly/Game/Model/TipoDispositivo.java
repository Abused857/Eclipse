package com.decroly.Game.Model;

public enum TipoDispositivo {

	cascosPs4(" Cascos compatibles con play station"),
	cascosPro(" Cascos de ps5"),
	cascosSwitch(" Cascos de switch"),
	cascosXbox(" Cascos de xbox"),
	cascosPX(" Cascos compatibles con play station y microsoft"), 
	cascosM(" Cascos multiplataforma"),
	cascosC(" Cascos para consolas"),
	teclado(" Teclado de pc"),
	tecladoM(" Teclado multiplataforma"),
	mandoPs(" Mando de playstation"),
	mandoX(" Mando Xbox"),
	mandoM(" Mando multiplataforma"),
	raton(" Ratón de pc"),
	ratonM(" Ratón multiplataforma"),
	mandoS(" Mando de switch");
	
	
	private final String descripcion;
	
	
	TipoDispositivo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}