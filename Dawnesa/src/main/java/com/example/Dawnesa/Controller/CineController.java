package com.example.Dawnesa.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dawnesa.Model.Butacas;
import com.example.Dawnesa.Model.Cine;
import com.example.Dawnesa.Model.Entradas;
import com.example.Dawnesa.Model.Peliculas;
import com.example.Dawnesa.Model.Sala;
import com.example.Dawnesa.Model.Sesiones;
import com.example.Dawnesa.Service.CineService;

@RestController
@RequestMapping("/cinemas")
public class CineController
{
	
	private final CineService cineService;
	
	public CineController(CineService cineService)
	{
		this.cineService = cineService;
	}

	@GetMapping("/{cod}")
	public Cine getCinemaByCod(@PathVariable("cod") String cod)
	{
		return this.cineService.getCinemaByCod(cod);
	}
	
	@GetMapping("/salas/{cod}")
	public List<Sala> getSalasByCinemaCod(@PathVariable("cod") String cod)
	{
		return this.cineService.getSalasByCinemasCode(cod);
	}
	
	@GetMapping("/salas/aforo/{aforo}")
	public List<Sala> getSalasByAforoWhereGreaterThan(@PathVariable("aforo") int aforo)
	{
		return this.cineService.getSalasWhereAforoGreaterThan(aforo);
	}
	@GetMapping("/butacas/{cod}")
	public Butacas getButacasByCod(@PathVariable("cod") String cod)
	{
		return this.cineService.getButacasByCod(cod);
	}
	
	@GetMapping("/butacasSalaCod/{cod}")
	
	public List<Butacas> getButacasBySalasCode(@PathVariable("cod") String cod)
	{
		
		return this.cineService.getButacasBySalasCode(cod);
	}
	
	@GetMapping("/peliculas/{cod}")
	public Peliculas getPeliculasByCod(@PathVariable("cod") String cod)
	{
		return this.cineService.getPeliculaByCod(cod);
	}
	
	@GetMapping("/sesiones/{cod}")
	public Sesiones getSesionesByCod(@PathVariable("cod") int cod)
	{
		return this.cineService.getSesionesByCod(cod);
	}
	
	@GetMapping("/entradas/{cod}")
	public Entradas getEntradasByCod(@PathVariable("cod") int cod)
	{
		return this.cineService.getEntradasByCod(cod);
	}
	
	
	@GetMapping("/{idSesion}/fechaFormateada")
	
    public String obtenerFechaFormateadaParaSesion1(@PathVariable int idSesion) {
		
        return cineService.fechaFormateada(idSesion);
    }
	//post param un butaca en una sala
	@PostMapping("/butacadeunaSala")
	public Butacas postButacaenUnaSala(@RequestParam String codButaca,
			@RequestParam boolean isVIP, @RequestParam int fila,@RequestParam boolean isDiscp,@RequestParam String codSala)
	{
		return this.cineService.postButacaenUnaSala(codButaca, isVIP, fila, isDiscp, codSala);
	}
	
	//post de las tablas
	
	@PostMapping("/cine")
	public Cine postCine(@RequestBody Cine cine)
	{
		return this.cineService.postCine(cine);
	}
	@PostMapping("/sala")
	public Sala postSala(@RequestBody Sala sala)
	{
		return this.cineService.postSala(sala);
	}
	@PostMapping("/butaca")
	public Butacas postButaca(@RequestBody Butacas butacas)
	{
		return this.cineService.postButacas(butacas);
	}
	
	//devolver todas las butacas sin entrada
	
	 @GetMapping("/sinEntrada")
	 public List<Butacas> obtenerButacasSinEntrada(@RequestParam int idSesion,@RequestParam String codSala) {
	        return cineService.obtenerButacasSinEntrada(idSesion, codSala);
	    }
	//añadir una nueva entrada
	 
	 @PostMapping("/nuevaEntrada")
	    public Entradas agregarNuevaEntrada(@RequestParam int idSesion,@RequestParam String codButaca,@RequestParam double precio) {
	        return cineService.agregarNuevaEntrada(idSesion, codButaca, precio);
	    }
	 
	 //quiero entender que puedo añadir path variable y paramater a la vez, probemos
	 @PutMapping("/{idEntrada}/modificaButaca")
	    public void modificarCodigoButaca(@PathVariable int idEntrada, @RequestParam String nuevoCodigoButaca) {
		 //sin return
	        cineService.modificarCodigoButaca(idEntrada, nuevoCodigoButaca);
	      
	    }
	 
	
	
	
	
}
