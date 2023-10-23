package com.decroly.Game.ProductoController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decroly.Game.Model.Producto;
import com.decroly.Game.Model.VideoJuego;
import com.decroly.Game.Service.GameService;
@RestController
@RequestMapping("/videojuego")
public class VideojuegoController {
	
	
	//Instancia del servicio
		private final GameService tiendaService;
		
		public VideojuegoController(GameService gameService) {
			this.tiendaService = gameService;
		}
		
		@GetMapping("/{sn}")
		public List <VideoJuego> getProduct(@PathVariable("sn") String sn)
		{

			return this.tiendaService.getProductByIdV(sn);
		}

}
