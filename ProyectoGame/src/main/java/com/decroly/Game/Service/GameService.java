package com.decroly.Game.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.stereotype.Service;

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
		
		public List <Producto> getProductos(){
			
			return this.gestion.devolverProductos();
		}
		
}
