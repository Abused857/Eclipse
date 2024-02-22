package com.example.Dawnesa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "entradas")
public class Entradas 
{
	

	@Id
	//estaba pisando la id porque la estaba creando yo
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//cone l autoincrement que tiene la tabla no me haria falta, pero busque esta manera tmb por si acaso en un futuro yo que se
	//cone la uto incrementar lo que si, cambia la id en labase de datos
	//pero en la api siempre muestra id 0, aunque sea la entrada con id 5 en la base ded atos por ejemplo
	@Column (name = "id", columnDefinition = "int(11) not null")
	private int id;
	
	@ManyToOne
	@JoinColumn (name = "id_sesion", columnDefinition = "int(11) not null")
	private Sesiones idSesion;
	
	@ManyToOne
	@JoinColumn (name = "cod_butaca", columnDefinition = "varchar(10) not null")
	private Butacas codButaca;
	
	@Column (name = "precio", columnDefinition = "double not null")
	private double precio;
	
	public Entradas (int id, Sesiones idSesion, Butacas codButaca, double precio) 
	{
		this.id = id;
		this.idSesion = idSesion;
		this.codButaca = codButaca;
		this.precio = precio;
	}
	public Entradas () 
	{}
	
	public Entradas(Sesiones idSesion, Butacas codButaca, double precio) {
	    this.idSesion = idSesion;
	    this.codButaca = codButaca;
	    this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sesiones getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(Sesiones idSesion) {
		this.idSesion = idSesion;
	}

	public Butacas getCodButaca() {
		return codButaca;
	}

	public void setCodButaca(Butacas codButaca) {
		this.codButaca = codButaca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	




















}
