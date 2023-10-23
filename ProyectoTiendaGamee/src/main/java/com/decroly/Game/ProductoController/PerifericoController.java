package com.decroly.Game.ProductoController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decroly.Game.Model.Perifericos;
import com.decroly.Game.Model.VideoJuego;
import com.decroly.Game.Service.GameService;

@RestController
@RequestMapping("/periferico")
public class PerifericoController {

	
	//Instancia del servicio
			private final GameService tiendaService;
			
			public PerifericoController(GameService gameService) {
				this.tiendaService = gameService;
			}
			
			@GetMapping("/{sn}")
			public List <Perifericos> getProduct(@PathVariable("sn") String sn)
			{

				return this.tiendaService.getProductByIdP(sn);
			}
}
