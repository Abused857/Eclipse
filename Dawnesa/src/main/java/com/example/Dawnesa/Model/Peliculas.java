package com.example.Dawnesa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "peliculas")
public class Peliculas {
	
	@Id
	@Column (name = "isan", columnDefinition = "varchar(45) not null")
	private String isan;
	
	@Column (name = "descripcion", columnDefinition ="varchar(500) not null")
	private String descripcion;
	
	@Column (name = "titulo", columnDefinition = "varchar(100) not null")
	private String titulo;
	
	@Column (name = "reparto", columnDefinition = "varchar(500) not null")
	private String reparto;
	
	@Column (name = "director", columnDefinition ="varchar(100) not null")
	private String director;
	
	@Column (name = "duracion", columnDefinition = "int(10) not null")
	private int duracion;
	
	@Column (name = "coste_licencia", columnDefinition = "double not null")
	private double costeLicencia;
	
	@Column (name ="fecha_estreno", columnDefinition = "bigint(20) not null")
	private long fecha;
	
	
	
	public Peliculas()
	{
		
	}
	
	public Peliculas(String isan, String descripcion, String titulo, String reparto, String director, int duracion, double costeLicencia, long fecha)
	
	{
		this.isan = isan;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.reparto = reparto;
		this.director = director;
		this.duracion = duracion;
		this.costeLicencia = costeLicencia;
		this.fecha = fecha;
	}
	
	
	/**
	 * @return the isan
	 */
	public String getIsan() {
		return isan;
	}

	/**
	 * @param isan the isan to set
	 */
	public void setIsan(String isan) {
		this.isan = isan;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return thetitulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo  the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return the reparto
	 */
	public String getReparto() {
		return reparto;
	}

	/**
	 * @param reparto the reparto to set
	 */
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	
	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * @return the costeLicencia
	 */
	public double getCosteLicencia() {
		return costeLicencia;
	}

	/**
	 * @param costeLicencia the dcosteLicencia to set
	 */
	public void setCosteLicencia(double costeLicencia) {
		this.costeLicencia = costeLicencia;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}
	
	

	
	
	
}
