package com.decroly.Game.ProductoController;

import java.security.Provider.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public Producto getProduct(@PathVariable("id") String id)
	{

		return this.tiendaService.getProductById(id);
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
		
		
		return this.tiendaService.getProductos();
		
		
	}
	
	
	
}