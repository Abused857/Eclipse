package com.decroly.Game.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.decroly.Game.Model.Consola;
import com.decroly.Game.Model.Perifericos;
import com.decroly.Game.Model.Producto;
import com.decroly.Game.Model.VideoJuego;
import com.decroly.Game.Repository.Gestion;

@Service
public class GameService {
	
	//Instancia al repositorio
		private final Gestion gestion;
		
		
		//Inicializamos el repositorio(es un singleton)
		public GameService(Gestion gestion)
		{
			this.gestion = gestion;
		}
		
		
		
		public Producto getProductById(String sn)
		{
			return this.gestion.devolverId(sn);
		}
		
		
	
		public List<VideoJuego> getAllVideojuegos()
		{
			return this.gestion.devolverVideoJuegos();
		}
		
		public List<Consola> getAllConsolas(){
			return this.gestion.devolverConsolas();
			
			
		}
		
		public List<Perifericos> getAllPerifericos(){
			
			return this.gestion.devolverAllPerifericos();
			
		
		}
		
		public List <Producto> getAllProductos(){
			
			return this.gestion.devolverAllProductos();
		}
		
		public Producto getDevolverNombreAllProductos(String nombre)
		{
			return this.gestion.devolverNombreAllProductos(nombre);
		}
		
		public List <Producto> getproductosMayor(int precio)
		{
			return this.gestion.filtrarProductosPorPrecioMayor(precio);
		}
		
		public List <Producto> getproductosMenor(int precio)
		{
			return this.gestion.filtrarProductosPorPrecioMenor(precio);
		}
		
		public List <Producto> getproductosIgual(int precio)
		{
			return this.gestion.filtrarProductosPorPrecioIgual(precio);
		}
		public List <Producto> getEdicion(String edicion)
		{
			return this.gestion.devolverEdicion(edicion);
		}
		
		public List <Producto> getPlataforma(String plataforma)
		{
			return this.gestion.filtrarProductosPorPlataforma(plataforma);
		}
		
		public List <VideoJuego> getProductByIdV(String sn)
		{
			return this.gestion.devolverIdV(sn);
		}
		public List<Perifericos> getProductByIdP(String sn)
		{
			return this.gestion.devolverIdP(sn);
		}
		
		public boolean addProduct(Producto p) {
			return this.gestion.Insertar(p);
		}
		public boolean upgradear(Producto p) {
			return this.gestion.productoUpdate(p);
		}
		public boolean eliminar(String sn)
		{
			return this.gestion.productoEliminar(sn);
		}
		
}
