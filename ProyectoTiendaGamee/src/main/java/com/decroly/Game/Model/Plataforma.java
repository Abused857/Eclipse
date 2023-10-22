package com.decroly.Game.Model;


public enum Plataforma {

	ps4(" Ps4 normal"),
	ps4Pro(" Ps4 pro"),
	ps4Slim(" Ps4 slim"),
	xbox(" Xbox estandar"),
	xbox360(" Xbox 360"), 
	xboxSlim(" Xbox slim"),
	xboxSeriesX(" Xbox series x"),
	xboxSeriesS(" Xbox series s"),
	nSwitch(" Nintendo switch oled"),
	pc(" Ordenador"),
	ps5(" Ps5 estandar"),
	ps5Pro(" Ps5 edición pro");
	
	
	private final String descripcion;
	
	
	Plataforma(String descripcion) {
        this.descripcion = descripcion;
    }

    // Metodo para que devuelva el string
    public String getDescripcion() {
        return descripcion;
    }
}
