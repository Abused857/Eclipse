package com.example.Dawnesa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "butacas")
public class Butacas 
{

	
	@Id
	@Column (name = "cod", columnDefinition = "varchar(10) not null")
	private String codButaca;
	
	@Column (name = "IsVIP", columnDefinition = "tinyint(1) not null")
	private boolean isVIP;
	
	@Column (name ="Fila", columnDefinition = "int(10) not null")
	private int fila;
	
	@Column (name = "is_Discp", columnDefinition = "tinyint(1) not null")
	private boolean isDiscp;
	
	
	@ManyToOne
	@JoinColumn (name = "cod_sala", columnDefinition = "varchar(20) not null")
	private Sala codSala;
	
	public Butacas()
	{
		
	}
	
	public Butacas(String codButaca, boolean isVIP, int fila, boolean isDiscp, Sala codSala) {
		this.codButaca = codButaca;
		this.isVIP = isVIP;
		this.fila = fila;
		this.isDiscp = isDiscp;
		this.codSala = codSala;
	
	}

	/**
	 * @return the filas
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * @param filas the filas to set
	 */
	public void setFilas(int fila) {
		this.fila = fila;
	}

	/**
	 * @return the isVIP
	 */
	public boolean isVIP() {
		return isVIP;
	}

	/**
	 * @param isVIP the isVIP to set
	 */
	public void setIsVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	/**
	 * @return the isDiscp
	 */
	public boolean isDiscp() {
		return isDiscp;
	}

	/**
	 * @param isDiscp the isDiscp to set
	 */
	public void setIsDiscp(boolean isDiscp) {
		this.isDiscp = isDiscp;
	}

	

	/**
	 * @return the codSala
	 */
	public Sala getCodSala() {
		return codSala;
	}

	/**
	 * @param codSala the codSala to set
	 */
	public void setCodSala(Sala codSala) {
		this.codSala = codSala;
	}

	public String getCodButaca() {
		return codButaca;
	}

	public void setCodButaca(String codButaca) {
		this.codButaca = codButaca;
	}
	

	
	
}
