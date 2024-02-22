package com.example.Dawnesa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "salas")
public class Sala 
{

	
	@Id
	@Column (name = "cod_sala", columnDefinition = "varchar(20) not null")
	private String codSala;
	
	@Column (name = "aforo", columnDefinition = "int(10) unsigned not null")
	private int aforo;
	
	@Column (name = "is_imax", columnDefinition = "tinyint(1) not null")
	private boolean isIMAX;
	
	@Column (name = "is_3d", columnDefinition = "inyint(1) not null")
	private boolean is3D;
	
	@Column (name = "is_dolby_atmos", columnDefinition ="inyint(1) not null")
	private boolean isDolbyAtmos;
	
	@Column (name = "n_filas", columnDefinition = "int(10) unsigned not null")
	private int nFilas;
	
	@ManyToOne
	@JoinColumn (name = "cod_cine", columnDefinition = "varchar(10) not null")
	private Cine codCine;
	
	public Sala()
	{
		
	}
	
	public Sala(String codSala, int aforo, boolean isIMAX, boolean is3d, boolean isDolbyAtmos, int nFilas,
			Cine codCine) {
		this.codSala = codSala;
		this.aforo = aforo;
		this.isIMAX = isIMAX;
		this.is3D = is3d;
		this.isDolbyAtmos = isDolbyAtmos;
		this.nFilas = nFilas;
		this.codCine = codCine;
	}

	/**
	 * @return the aforo
	 */
	public int getAforo() {
		return aforo;
	}

	/**
	 * @param aforo the aforo to set
	 */
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	/**
	 * @return the isIMAX
	 */
	public boolean isIMAX() {
		return isIMAX;
	}

	/**
	 * @param isIMAX the isIMAX to set
	 */
	public void setIMAX(boolean isIMAX) {
		this.isIMAX = isIMAX;
	}

	/**
	 * @return the is3D
	 */
	public boolean isIs3D() {
		return is3D;
	}

	/**
	 * @param is3d the is3D to set
	 */
	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}

	/**
	 * @return the isDolbyAtmos
	 */
	public boolean isDolbyAtmos() {
		return isDolbyAtmos;
	}

	/**
	 * @param isDolbyAtmos the isDolbyAtmos to set
	 */
	public void setDolbyAtmos(boolean isDolbyAtmos) {
		this.isDolbyAtmos = isDolbyAtmos;
	}

	/**
	 * @return the nFilas
	 */
	public int getnFilas() {
		return nFilas;
	}

	/**
	 * @param nFilas the nFilas to set
	 */
	public void setnFilas(int nFilas) {
		this.nFilas = nFilas;
	}

	/**
	 * @return the codCine
	 */
	public Cine getCodCine() {
		return codCine;
	}

	/**
	 * @param codCine the codCine to set
	 */
	public void setCodCine(Cine codCine) {
		this.codCine = codCine;
	}

	/**
	 * @return the codSala
	 */
	public String getCodSala() {
		return codSala;
	}
	
}
