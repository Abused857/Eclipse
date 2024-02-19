package com.decroly.pruebasecurity.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.decroly.pruebasecurity.Model.Cliente;
import com.decroly.pruebasecurity.Model.Compra;
import com.decroly.pruebasecurity.Model.Factura;
import com.decroly.pruebasecurity.Model.Producto;
import com.decroly.pruebasecurity.Repository.ClienteRepository;
import com.decroly.pruebasecurity.Repository.CompraRepository;
import com.decroly.pruebasecurity.Repository.FacturaRepository;
import com.decroly.pruebasecurity.Repository.ProductoRepository;











@Service
public class FacService 
{
	private final ClienteRepository clienteRepository;
	private final CompraRepository compraRepository;
	private final FacturaRepository facturaRepository;
	private final ProductoRepository productoRepository;
	

	public FacService(ClienteRepository clienteRepository, CompraRepository compraRepository, FacturaRepository facturaRepository, ProductoRepository productoRepository)
	{
		this.clienteRepository = clienteRepository;
		this.compraRepository = compraRepository;
		this.facturaRepository = facturaRepository;
		this.productoRepository = productoRepository;

	}
	
	public Producto getProductoByCod(String cod)
	{
		return this.productoRepository.findById(cod).orElse(null);
		
	}
	
	public List<Producto> getProductoAll()
	{
		return this.productoRepository.findAll();
		
	}
	
	public List<Producto> obtenerProductoPorRango(double precio1 , double precio2) {
		
		List<Producto> todos = new ArrayList<>();
		
		List<Producto> productosRango = new ArrayList<>();
		
		todos = this.productoRepository.findAll();

		for (Producto producto : todos) {
			System.out.println(producto.getPrecio());
			
			if (producto.getPrecio() > precio1 && producto.getPrecio() < precio2) {
				
				productosRango.add(producto);

			}
	
		}

		return productosRango;

    }
	
	public Producto getProductoBySn(String sn)
	{
		List<Producto> todos = new ArrayList<>();
		todos = this.productoRepository.findAll();
		
		if (sn != null) {
			for (Producto producto : todos) {
				System.out.println(producto.getPrecio());
				
				if (producto.getSn().equals(sn) ) {
					System.out.println(producto.getSn());
					return producto;
	
				}

			}
		}

		return null;

	}
	
public Producto modificarSn(String id , String sn) {
	
	if (id == null) {
		return null;
	}
	
	Producto producto = this.productoRepository.findById(id).orElse(null);
	String snLimpio = sn.trim();
	if (snLimpio != "") {
		
		producto.setSn(sn);
		productoRepository.save(producto);
		return producto;
	}
	
	
	return null;
		
		

    }

public Producto modificarNombre(String id , String nombre) {
	
	if (id == null) {
		return null;
	}
	
	Producto producto = this.productoRepository.findById(id).orElse(null);
	String nombreLimpio = nombre.trim();
	if (nombreLimpio != "") {
		
		producto.setNombre(nombre);
		productoRepository.save(producto);
		return producto;
	}
	
	
	return null;
		
		

    }

public Producto modificarDescripcion(String id , String descripcion) {
	
	if (id == null) {
		return null;
	}
	
	Producto producto = this.productoRepository.findById(id).orElse(null);
	String nombreLimpio = descripcion.trim();
	if (nombreLimpio != "") {
		
		producto.setDescripcion(descripcion);
		productoRepository.save(producto);
		return producto;
	}
	
	
	return null;
		
		

    }

public Producto modificarPrecio(String id , double precio) {
	
	if (id == null) {
		return null;
	}
	
	Producto producto = this.productoRepository.findById(id).orElse(null);

		
		producto.setPrecio(precio);
		productoRepository.save(producto);
		return producto;

    }

public Producto modificarProductoBody(Producto product)
{
	if(product != null) {
		
		String codPro = product.getCodPro();
		
		Producto producto = this.productoRepository.findById(codPro).orElse(null);
		
		producto = product;
		productoRepository.save(producto);
	
	
		
		return product;
	}
	return null;
	
	
}

public Producto postProductoBody(Producto producto)
{
	if(producto != null) {
	
		this.productoRepository.save(producto);
		
		return producto;
	}
	return null;
	
	
}

public Producto postProductoParam(String codPro, String sn, String nombre, String descripcion, double precio)
{
	
	Producto producto = new Producto (codPro, sn, nombre, descripcion, precio);
	if (producto != null) {
		this.productoRepository.save(producto);
	}
	
	return producto;
	
	
	
}

public Producto productoEliminar(String codPro)
{
	List<Producto> todos = new ArrayList<>();
	todos = this.productoRepository.findAll();
	
	if (codPro != null) {
		for (Producto producto : todos) {
			
			
			if (producto.getCodPro().equals(codPro) ) {
				
				this.productoRepository.deleteById(codPro);
				
			

			}

		}
	}
	
	
	
	
	
	return null;
	

	
	
	
}

public List<Cliente> getClienteAll()
{
	return this.clienteRepository.findAll();
	
}

public Cliente getClientePorNif(String nif)
{
	return this.clienteRepository.findById(nif).orElse(null);
	
}

public Cliente getClientePorNombre(String nombre)
{
	return this.clienteRepository.findById(nombre).orElse(null);
	
}

public Cliente getclientePorTelefono(String telefono)
{
	List<Cliente> todos = new ArrayList<>();
	
	todos = this.clienteRepository.findAll();
	
	
	Cliente clientes = null;
	
	for (Cliente cliente : todos) {

		
		if (cliente.getTelefono().contains(telefono)) {
		
			return cliente;

		}
		
	}
	return null;
	
}
public Cliente getClientePorNombreP(String nombre)
{
	List<Cliente> todos = new ArrayList<>();
	

	
	todos = this.clienteRepository.findAll();

	for (Cliente cliente : todos) {
		
		
		if (cliente.getNombre().contains(nombre)) {
			
			return cliente;

		}

	}

	return null;


	
	
	
}

public Cliente getClientePorEmail(String email)
{
	List<Cliente> todos = new ArrayList<>();
	

	
	todos = this.clienteRepository.findAll();

	for (Cliente cliente : todos) {
		
		
		if (cliente.getDireccion().contains(email)) {
			
			return cliente;

		}

	}

	return null;

}

public Cliente clienteEliminar(String codCliente)
{
	List<Cliente> todos = new ArrayList<>();
	todos = this.clienteRepository.findAll();
	
	if (codCliente != null) {
		for (Cliente cliente : todos) {
			
			
			if (cliente.getNif().equals(codCliente) ) {
				
				this.clienteRepository.deleteById(codCliente);
				
			

			}

		}
	}
	return null;
	

}

public Factura getFacturasPorCod(String facCod)
{
	List<Factura> todos = new ArrayList<>();
	

	
	todos = this.facturaRepository.findAll();

	for (Factura factura : todos) {
		
		
		if (factura.getCodFact().contains(facCod)) {
			
			return factura;

		}

	}

	return null;

}

public Factura getFacturasPorCliente(String facCliente)
{
	List<Factura> todos = new ArrayList<>();
	

	
	todos = this.facturaRepository.findAll();

	for (Factura factura : todos) {
		
		
		if (factura.getCodNif().getNif().contains(facCliente)) {
			
			return factura;

		}

	}

	return null;

}

public Factura getFacturasPorFecha(Long fecha)
{
	List<Factura> todos = new ArrayList<>();
	
	String fechaF = formatearFecha(fecha);
	
	todos = this.facturaRepository.findAll();

	for (Factura factura : todos) {
		
		
		if (formatearFecha(factura.getFecha()).contains(fechaF)) {
			
			return factura;

		}

	}

	return null;

}

public Factura getFacturasPorImporte(double importe)
{
	List<Factura> todos = new ArrayList<>();
	

	
	todos = this.facturaRepository.findAll();

	for (Factura factura : todos) {
		
		
		if (factura.getTotal() == importe) {
			
			return factura;

		}

	}

	return null;

}

public Factura postFacturaUnaLinea(String codFact, Long fecha, String codNif, double baseImponible, double total, String codCompra) {
	 

	 
    Cliente cliente = clienteRepository.findById(codNif).orElse(null);
    Compra compra = compraRepository.findById(codCompra).orElse(null);

    if (cliente != null && compra != null) {
        
        Factura nuevaFactura = new Factura(codFact, fecha, cliente, baseImponible, total, compra);


        facturaRepository.save(nuevaFactura);
      
        return nuevaFactura;
        
    } else {

        return null;
    }
}

public Factura facturaEliminar(String codFac)
{
	List<Factura> todos = new ArrayList<>();
	todos = this.facturaRepository.findAll();
	
	if (codFac != null) {
		for (Factura factura : todos) {
			
			
			if (factura.getCodFact().equals(codFac) ) {
				
				this.facturaRepository.deleteById(codFac);
				
			

			}

		}
	}
	return null;
	

}

public Factura postMuchasFacturas(Factura factura)
	{
		if(factura != null) {
			this.facturaRepository.save(factura);
			
			
		}
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
private String formatearFecha(long fechaEnMillis) {
	 
    Instant instant = Instant.ofEpochMilli(fechaEnMillis);
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return localDateTime.format(formatter);
}
	
	
}
