package com.decroly.pruebasecurity.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "producto")
public class Producto {
	
	@Id
	@Column (name = "cod_pro", columnDefinition = "varchar(10) not null")
	private String codPro;
	
	@Column (name = "sn", columnDefinition = "varchar(30) not null")
	private String sn;
	
	@Column (name = "nombre", columnDefinition = "varchar(50) not null")
	private String nombre;
	
	@Column (name = "descripcion", columnDefinition = "varchar(100) null")
	private String descripcion;
	
	@Column (name = "precio", columnDefinition = "double not null")
	private double precio;
	
	public Producto()
	{
		
	}
	
	public Producto(String codPro, String sn, String nombre, String descripcion, double precio)
	{
		this.codPro = codPro;
		this.sn = sn;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	

}
