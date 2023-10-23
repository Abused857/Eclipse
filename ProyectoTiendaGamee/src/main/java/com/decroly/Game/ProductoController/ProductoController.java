package com.decroly.Game.ProductoController;

import java.security.Provider.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decroly.Game.Model.Consola;
import com.decroly.Game.Model.Perifericos;
import com.decroly.Game.Model.Producto;
import com.decroly.Game.Model.VideoJuego;
import com.decroly.Game.Service.GameService;


@RestController
@RequestMapping("/products")
public class ProductoController 
{
	//Instancia del servicio
	private final GameService tiendaService;
	
	public ProductoController(GameService gameService) {
		this.tiendaService = gameService;
	}
	
	@GetMapping("/{sn}")
	public Producto getProduct(@PathVariable("sn") String sn)
	{

		return this.tiendaService.getProductById(sn);
	}
	
	
	@GetMapping("/VideoJuegos")
	public List<VideoJuego> getVideojuegos()
	{
		return this.tiendaService.getAllVideojuegos();
	}
	@GetMapping("/Consolas")
	public List<Consola> getAllConsolas(){
		return this.tiendaService.getAllConsolas();
		
	}
	
	@GetMapping("/Perifericos")
	public List <Perifericos> getPerifericos(){
		
		return this.tiendaService.getAllPerifericos();
		
	}
	
	@GetMapping("/Producto")
	public List <Producto> getProductos(){

		return this.tiendaService.getAllProductos();

	}
	
	//se pisaba con el primer metodo de serial number porque los dos eran string, cosa mas rara
	@GetMapping("/productByName/{nombre}")
	public Producto getDevolverNombreAllProductos(@PathVariable("nombre") String nombre)
	{

		return this.tiendaService.getDevolverNombreAllProductos(nombre);
	}
	
	@GetMapping("/productMayor/{precio}")
	public List <Producto> getproductoMayor(@PathVariable("precio") int precio)
	{

		return this.tiendaService.getproductosMayor(precio);
	}
	
	@GetMapping("/productMenor/{precio}")
	public List <Producto> getproductoMenor(@PathVariable("precio") int precio)
	{

		return this.tiendaService.getproductosMenor(precio);
	}
	
	@GetMapping("/productIgual/{precio}")
	public List <Producto> getproductoIgual(@PathVariable("precio") int precio)
	{

		return this.tiendaService.getproductosIgual(precio);
	}
	
	@GetMapping("/productEdicion/{edicion}")
	public List <Producto> getproductEdicion(@PathVariable("edicion") String edicion)
	{

		return this.tiendaService.getEdicion(edicion);
	}
	
	@GetMapping("/productsPlataforma/{plataforma}")
	public List <Producto> getproductPlataforma(@PathVariable("plataforma") String plataforma)
	{

		return this.tiendaService.getPlataforma(plataforma);
	}
	
	@PostMapping("/admin/addP")
	public boolean addProduct(@RequestBody Producto producto) {
		return tiendaService.addProduct(producto);
	}
	
	
	
	
}