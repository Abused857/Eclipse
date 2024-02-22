package com.example.Dawnesa.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.Dawnesa.Model.Butacas;
import com.example.Dawnesa.Model.Cine;
import com.example.Dawnesa.Model.Entradas;
import com.example.Dawnesa.Model.Peliculas;
import com.example.Dawnesa.Model.Sala;
import com.example.Dawnesa.Model.Sesiones;
import com.example.Dawnesa.Repository.ButacasRepository;
import com.example.Dawnesa.Repository.CineRepository;
import com.example.Dawnesa.Repository.EntradasRepository;
import com.example.Dawnesa.Repository.PeliculasRepository;
import com.example.Dawnesa.Repository.SalaRepository;
import com.example.Dawnesa.Repository.SesionesRepository;

import ch.qos.logback.core.boolex.Matcher;

@Service
public class CineService 
{
	private final CineRepository cineRepository;
	private final SalaRepository salaRepository;
	private final ButacasRepository butacasRepository;
	private final PeliculasRepository peliculasRepository;
	private final SesionesRepository sesionesRepository;
	private final EntradasRepository entradasRepository;

	public CineService(CineRepository cineRepository, SalaRepository salaRepository, ButacasRepository butacasRepository, PeliculasRepository peliculasRepository, SesionesRepository sesionesRepository, EntradasRepository entradasRepository)
	{
		this.cineRepository = cineRepository;
		this.salaRepository = salaRepository;
		this.butacasRepository = butacasRepository;
		this.peliculasRepository = peliculasRepository;
		this.sesionesRepository = sesionesRepository;
		this.entradasRepository = entradasRepository;
	}
	
	public Cine getCinemaByCod(String cod)
	{
		return this.cineRepository.findById(cod).orElse(null);
		
	}
	public Butacas getButacasByCod(String cod)
	{
		return this.butacasRepository.findById(cod).orElse(null);
		
	}
	
	public List<Sala> getSalasByCinemasCode(String code)
	{
		Cine cine = this.getCinemaByCod(code);
		return this.salaRepository.findByCodCine(cine);
	}
	
	public List<Sala> getSalasWhereAforoGreaterThan(int aforo)
	{
		return this.salaRepository.findByAforoGreaterThanEqual(aforo);
	}
	
	public List<Butacas> getButacasBySalasCode(String codeSala)
	{
		Sala sala = this.salaRepository.findById(codeSala).orElse(null);
		return this.butacasRepository.findByCodSala(sala);
	}
	
	public Peliculas getPeliculaByCod(String cod)
	{
		return this.peliculasRepository.findById(cod).orElse(null);
	}
	
	public Sesiones getSesionesByCod(int cod)
	{
		return this.sesionesRepository.findById(cod).orElse(null);
	}
	
	public Entradas getEntradasByCod(int cod)
	{
		return this.entradasRepository.findById(cod).orElse(null);
	}
	
	//ñpost con params
	
	public Butacas postButacaenUnaSala(String codButaca, boolean isVIP, int fila, boolean isDiscp, String codSala)
	{
		
		Sala sala = salaRepository.findById(codSala).orElse(null);

		if (codButaca != null || sala != null){
			
			Butacas  butacas = new Butacas(codButaca, isVIP,fila, isDiscp, sala);
			this.butacasRepository.save(butacas);
			
			return butacas;
		}
		return null;
	}
		
		
			
		
	
	//post entities
	
	public Cine postCine(Cine cine)
	{
		if(cine != null) {
			this.cineRepository.save(cine);
			
			return cine;
		}
		return null;
		
		
	}
	
	public Sala postSala(Sala sala)
	{
		if(sala.getCodSala().contains("sa")) {
			sala.setCodCine(sala.getCodCine());
			this.salaRepository.save(sala);
			
			return sala;
		}
		return null;
		
		
	}
	
	public Butacas postButacas(Butacas butacas)
	{
		if(butacas != null) {
		
			this.butacasRepository.save(butacas);
			
			return butacas;
		}
		return null;
		
		
	}
	
	//lista de todas las butacas que no tienen entrada
	
	public List<Butacas> obtenerButacasSinEntrada(int idSesion, String codSala) {
		
	    Sesiones sesion = sesionesRepository.findById(idSesion).orElse(null);
	    System.out.println("idSesion: " + sesion.getId());
	    
	    List<Entradas> entradasEnSesion = entradasRepository.findByIdSesion(sesion);

	    Sala sala = salaRepository.findById(codSala).orElse(null);
	    System.out.println("codSala: " + sala.getCodSala());
	    List<Butacas> butacasDeLaSala = butacasRepository.findByCodSala(sala);

	    List<Butacas> butacasSinEntrada = new ArrayList<>();

	    for (Butacas butaca : butacasDeLaSala) {
	    	
	        boolean tieneEntrada = false;

	        // Verificar si TIENE ENTRADA
	        
	        //por cada butaca mirar si en la lista de entradas esta ya su codigo, tengo que hacer doble get codigo porque en entradas devuelve el objeto entrada  cone l primer getcod y con el segundo el string ya
	        for (Entradas entrada : entradasEnSesion) {
	
	            if (butaca.getCodButaca().equals(entrada.getCodButaca().getCodButaca())) {
	            	
	            	System.out.println("Butaca con entrada: " + butaca.getCodButaca());
	                tieneEntrada = true;
	                break;
	            }
	        }

	        // Si la butaca no tiene se añade
	        if (!tieneEntrada) {
	            butacasSinEntrada.add(butaca);
	        }
	    }

	    return butacasSinEntrada;
	}
	
	 public Entradas agregarNuevaEntrada(int idSesion, String codButaca, double precio) {
	 

	 
	        Sesiones sesion = sesionesRepository.findById(idSesion).orElse(null);
	        Butacas butaca = butacasRepository.findById(codButaca).orElse(null);

	        if (sesion != null && butaca != null) {
	            
	            Entradas nuevaEntrada = new Entradas(sesion, butaca, precio);

	
	            entradasRepository.save(nuevaEntrada);
	            System.out.println("Entrada guardada correctamente: " + nuevaEntrada);
	            return nuevaEntrada;
	            
	        } else {
	    
	            return null;
	        }
	    }
	 
	 //hacer le put de una entrada para poner otra butaca
	 
	 public void modificarCodigoButaca(int idEntrada, String nuevoCodigoButaca) {
		 
		 //saco la row de entradas / objeto
	        Entradas entrada = entradasRepository.findById(idEntrada).orElse(null);

	        if (entrada != null) {
	        	
	        	//hago que la butaca sea la del id que paso por la api
	            Butacas butacaNueva = butacasRepository.findById(nuevoCodigoButaca).orElse(null);
	            
	            if (butacaNueva != null) {
	            	
	            	//no se me ocurria otra manera que no sea a traves del set el id, aunque deberia estar en privado ye sas cosas
	                entrada.setCodButaca(butacaNueva);

	                //y ahora quelo modifique entiendo que lo guardo y se actualiza?
	                entradasRepository.save(entrada);

	             
	            } else {
	                System.out.println("null en la butaca");
	            }
	        } else {
	            System.out.println("null en la entrada");
	        }
	    }
	 
	 
	 public String fechaFormateada(int idSesion) {
	        Sesiones sesion = sesionesRepository.findById(idSesion).orElse(null);

	        if (sesion != null) {
	            return formatearFecha(sesion.getFecha());
	        } else {
	            return "sesion null";
	        }
	    }
	 public Cine postCine(Cine cine)
		{
			if(cine != null) {
				this.cineRepository.save(cine);
				
				return cine;
			}
			return null;
			
			
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	 //para le examen , para no tener abierto ningun otro proyecto
	 public boolean validarNombre(String nombre) {
	
		    String patron = "^[A-Z][a-z]*$";

	
		    return nombre.matches(patron);
		}
	 
	 public boolean validarDNI(String dni) {
	
		    String patron = "^[0-9]{8}[A-Za-z]$";


		    return dni.matches(patron);
		}
	 
	 //como si leyese chino no te voy a engañar Instant instant = Instant.ofEpochMilli(fechaEnMillis);
     //.ofInstant(instant, ZoneId.systemDefault());
	 //se a donde quiere ir a para, no hubiera llegado en la vida a escribir esto, copia y pega
	 private String formatearFecha(long fechaEnMillis) {
		 
	        Instant instant = Instant.ofEpochMilli(fechaEnMillis);
	        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        return localDateTime.format(formatter);
	    }
	 
	 
	 
	


}