package com.decroly.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SaludoController 
{

	@GetMapping("/")
	public String saludar() 
	{
		return "Bienvenido a aplicaciones adre" + "<p> <a href=logout>Cerrar sesion</a></p>";
		
	}
	
	
}
