package com.decroly.facturacion.Model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "factura")
public class Factura {
	
	@Id
	@Column (name = "cod_fact", columnDefinition = "varchar(20) not null")
	private String codFact;
	
	@Column (name = "fecha", columnDefinition = "bigint(20) not null")
	private long fecha;
	
	@ManyToOne
	@JoinColumn (name = "nif", columnDefinition = "varchar(10) not null")
	private Cliente codNif;
	
	@Column (name = "base_imponible", columnDefinition = "double not null")
	private double baseImponible;
	
	@Column (name = "total", columnDefinition = "double not null")
	private double total;
	
	@ManyToOne
	@JoinColumn (name = "cod_compra", columnDefinition = "varchar(10) not null")
	private Compra codCompra;
	
	
	public Factura () 
	
	{
		
	}
	
public Factura (String codFact, long fecha, Cliente codNif, double baseImponible, double total, Compra codCompra) 
	
	{
	
		this.codFact = codFact;
		this.fecha = fecha;
		this.codNif = codNif;
		this.fecha = fecha;
		this.baseImponible = baseImponible;
		this.total = total;
		this.codCompra = codCompra;
	
	}

	public String getCodFact() {
		return codFact;
	}
	
	public void setCodFact(String codFact) {
		this.codFact = codFact;
	}
	
	public long getFecha() {
		return fecha;
	}
	
	public void setFecha(long fecha) {
		this.fecha = fecha;
	}
	
	public Cliente getCodNif() {
		return codNif;
	}
	
	public void setCodNif(Cliente codNif) {
		this.codNif = codNif;
	}
	
	public double getBaseImponible() {
		return baseImponible;
	}
	
	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Compra getCodCompra() {
		return codCompra;
	}
	
	public void setCodCompra(Compra codCompra) {
		this.codCompra = codCompra;
	}


	
	

}
