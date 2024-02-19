package com.decroly.pruebasecurity.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decroly.pruebasecurity.Model.Cliente;
import com.decroly.pruebasecurity.Model.Factura;
import com.decroly.pruebasecurity.Model.Producto;
import com.decroly.pruebasecurity.Service.FacService;

@RestController
@RequestMapping("/fac")
public class FacController
{
	
	private final FacService facService;
	
	public FacController(FacService facService)
	{
		this.facService = facService;
	}
	
	@GetMapping("/")
	public String saludar() 
	{
		return "Bienvenido a aplicaciones adre" + "<p> <a href=logout>Cerrar sesion</a></p>";
		
	}
	
	@GetMapping("/{cod}")
	public Producto getProductoByCod(@PathVariable("cod") String cod)
	{
		return this.facService.getProductoByCod(cod);
	}
	
	@GetMapping("/allProduc")
	public List<Producto> getProductoAll()
	{
		return this.facService.getProductoAll();
	}
	
	@GetMapping("/rango")
	public List<Producto> obtenerProductoPorRango(@RequestParam double precio1 ,@RequestParam double precio2) {
        return facService.obtenerProductoPorRango(precio1, precio2);
    }
	
	@GetMapping("/productoSn")
	public Producto getProductoBySn(@RequestParam String sn)
	{
		return this.facService.getProductoBySn(sn);
	}
	//modificar producto de distintas maneras
	//por sn
	 @PutMapping("/{idProducto}/modificarSn")
	    public void modificarSn(@PathVariable String idProducto, @RequestParam String sn) {
		 //sin return
	        facService.modificarSn( idProducto, sn);
	      
	    }
	//por sn
		 @PutMapping("/{idProducto}/modificarNombre")
		    public void modificarNombre(@PathVariable String idProducto, @RequestParam String nombre) {
			 //sin return
		        facService.modificarNombre( idProducto, nombre);
		      
		    }
		 
		 @PutMapping("/{idProducto}/modificarDescripcion")
		    public void modificarDescripcion(@PathVariable String idProducto, @RequestParam String descripcion) {
			 //sin return
		        facService.modificarDescripcion( idProducto, descripcion);
		      
		    }
		 
		 @PutMapping("/{idProducto}/modificarPrecio")
		    public void modificarPrecio(@PathVariable String idProducto, @RequestParam double precio) {
			 //sin return
		        facService.modificarPrecio( idProducto, precio);
		      
		    }
		 
		 @PutMapping("/modificarProductoBody")
			public Producto modificarProductoBody(@RequestBody Producto producto)
			{
				return this.facService.modificarProductoBody(producto);
			}
		 //siguiente filtro voy en orden, agregar lo hare con parama y body, y a partir de aqui usare ya solo param
		 //en los siguiente filtros
		 @PostMapping("/addProductoBody")
			public Producto postProductoBody(@RequestBody Producto producto)
			{
				return this.facService.postProductoBody(producto);
			}
		 
		 @PostMapping("/addProductoParam")
			public Producto postProductoParam(@RequestParam String codPro, @RequestParam String sn, @RequestParam String nombre, @RequestParam String descripcion, @RequestParam Double precio)
			{
				return this.facService.postProductoParam(codPro, sn, nombre, descripcion, precio);
			}
		 //cambie la fk de producto para hacer el borrado en cascade
		 @DeleteMapping("/EliminarProducto")
			public Producto productoEliminar(@RequestParam String codPro)
			{
				return this.facService.productoEliminar(codPro);
			}
		 
		 @GetMapping("/allClientes")
			public List<Cliente> getClienteAll()
			{
				return this.facService.getClienteAll();
			}
		 
		 @GetMapping("/clientePorNif/{dni}")
			public Cliente getClientePorNif(@PathVariable("dni") String dni)
			{
				return this.facService.getClientePorNif(dni);
			}
		 @GetMapping("/clientePorNombre/{nombre}")
			public Cliente getClientePorNombre(@PathVariable("nombre") String nombre)
			{
				return this.facService.getClientePorNombre(nombre);
			}
		 
		 @GetMapping("/clientePorNombreP")
			public Cliente getClientePorNombreP(@RequestParam String nombre)
			{
				return this.facService.getClientePorNombreP(nombre);
			}
		 
		 @GetMapping("/clientePorTelefono")
			public Cliente getclientePorTelefono(@RequestParam String telefono)
			{
				return this.facService.getclientePorTelefono(telefono);
			}
		 
		 @GetMapping("/clientePorEmail")
			public Cliente getClientePorEmail(@RequestParam String email)
			{
				return this.facService.getClientePorEmail(email);
			}
		 @DeleteMapping("/EliminarCliente")
		 public Cliente clienteEliminar(@RequestParam String codCliente)
			{
				return this.facService.clienteEliminar(codCliente);
			}
		 
		 @GetMapping("/facturasPorCod")
			public Factura getFacturasPorCod(@RequestParam String facCod)
			{
				return this.facService.getFacturasPorCod(facCod);
			}
		 
		 @GetMapping("/facturasPorCliente")
			public Factura getFacturasPorCliente(@RequestParam String facCliente)
			{
				return this.facService.getFacturasPorCliente(facCliente);
			}
		 
		 @GetMapping("/facturasPorFecha")
			public Factura getFacturasPorFecha(@RequestParam Long fecha)
			{
				return this.facService.getFacturasPorFecha(fecha);
			}
		 
		 @GetMapping("/facturasPorImporte")
			public Factura getFacturasPorImporte(@RequestParam double importe)
			{
				return this.facService.getFacturasPorImporte(importe);
			}
		 
		 @PostMapping("/facturaUnaLinea")
			public Factura postFacturaUnaLinea(@RequestParam String codFact,
					@RequestParam long fecha, @RequestParam String codNif,@RequestParam double baseImponible,@RequestParam double total, @RequestParam String codCompra)
			{
				return this.facService.postFacturaUnaLinea(codFact, fecha, codNif, baseImponible, total, codCompra);
			}
		 
		 @DeleteMapping("/EliminarFactura")
			public Factura facturaEliminar(@RequestParam String codFac)
			{
				return this.facService.facturaEliminar(codFac);
			}
		 
		 @PostMapping("/facturaMuchosProductos")
			public Factura postMuchasFacturas(@RequestBody Factura factura)
			{
				return this.facService.postMuchasFacturas(factura);
			}
		 
		
		 
		 
		 
	
		 
		 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
