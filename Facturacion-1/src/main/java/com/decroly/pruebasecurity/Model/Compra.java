package com.decroly.pruebasecurity.Model;






import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "linea_compra")
public class Compra {
	
	@Id
	@Column (name = "cod_compra", columnDefinition = "varchar(10) not null")
	private String codCompra;
	
	@ManyToOne
	@JoinColumn (name = "cod_pro", columnDefinition = "varchar(10) not null")
	private Producto codPro;
	
	
	@Column (name = "cantidad", columnDefinition = "int(11) not null")
	private int cantidad;
	
	public Compra()
	{
		
	}
	
	public Compra(String codCompra, Producto codPro, int cantidad) {
		this.codCompra = codCompra;
		this.codPro = codPro;
		this.cantidad = cantidad;
	
	}

	public String getCodCompra() {
		return codCompra;
	}

	public void setCodCompra(String codCompra) {
		this.codCompra = codCompra;
	}

	public Producto getCodPro() {
		return codPro;
	}

	public void setCodPro(Producto codPro) {
		this.codPro = codPro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
