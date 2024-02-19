package com.decroly.asla.Controller;


import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decroly.asla.Model.Autobus;
import com.decroly.asla.Model.Pasajero;
import com.decroly.asla.Model.Reserva;
import com.decroly.asla.Model.Ruta;
import com.decroly.asla.Model.Ticket;
import com.decroly.asla.Service.AlsaService;







@RestController
@RequestMapping("/alsa")
public class AlsaController {

	
	
	private final AlsaService alsaService;
	

	public AlsaController(AlsaService alsaService)
	{
		this.alsaService = alsaService;
	}

	//getters
	
	/*
	 * public class StringGetBytesExample{  
public static void main(String args[]){  
String s1="ABCDEFG";  
byte[] barr=s1.getBytes();  
for(int i=0;i<barr.length;i++){  
System.out.println(barr[i]);  
}  
}}  
	 */
	
	
	//GETTERS
	
	
	
		//tabla autobus
	@GetMapping("/buscar/id/{id}")
	public Object buscarAutobusById(@PathVariable String id) {
	    byte[] idByte;
	    
	   
	    if (id.startsWith("0x")) {
	      
	        String hexUUID = id.substring(2);
	       
	        idByte = hexStringToByteArray(hexUUID);
	    } else {
	       
	        idByte = id.getBytes();
	    }
	    
	  
	    Autobus autobus = alsaService.buscarAutobusById(idByte);
	    
	    if (autobus != null) {
	        return autobus;
	    } else {
	        return "La UUID no se encontró o es null";
	    }
	}

	// metodo para pasar la cadena hexadecimal sin el 0x a bytes
	private byte[] hexStringToByteArray(String hex) {
	    int len = hex.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
	                             + Character.digit(hex.charAt(i + 1), 16));
	    }
	    return data;
	}

	
	@GetMapping("/buscar/allBuses")
	public List<Autobus> getAutobesAll()
	{
		return this.alsaService.getAutobusesAll();
	}
	
	@GetMapping("/buscar/modelo/{modelo}")
	public List<Autobus> getAutobusesByModelo(@PathVariable String modelo) {
	    return alsaService.getBuscarAutobusesByModelo(modelo);
	}

	@GetMapping("/buscar/capacidad/entre/{capacidad1}/{capacidad2}")
	public List<Autobus> obtenerProductoPorRango(@PathVariable int capacidad1, @PathVariable int capacidad2) {
	    return alsaService.obtenerAutobusByCapacidad_Entre(capacidad1, capacidad2);
	}
	
	@GetMapping("/buscar/capacidad/mayor/{capacidad}")
	public List<Autobus> obtenerAutobusesByCapacidadMayor(@PathVariable int capacidad) {
	    return alsaService.obtenerAutobusByCapacidadMayor(capacidad);
	}
	
	@GetMapping("/buscar/capacidad/menor/{capacidad}")
	public List<Autobus> obtenerAutobusesByCapacidadMenor(@PathVariable int capacidad) {
	    return alsaService.obtenerAutobusByCapacidadMenor(capacidad);
	}
	@GetMapping("/buscar/capacidad/igual/{capacidad}")
	public List<Autobus> obtenerAutobusesByCapacidadIgual(@PathVariable int capacidad) {
	    return alsaService.obtenerAutobusByCapacidadIgual(capacidad);
	}
	
	@GetMapping("/buscar/placa/{placa}")
	public List<Autobus> getAutobusesByPlaca(@PathVariable String placa) {
	    return alsaService.getBuscarAutobusesByPlaca(placa);
	}
	
	@GetMapping("/buscar/color/{color}")
	public List<Autobus> getAutobusesByColor(@PathVariable String color) {
	    return alsaService.getAutobusesByColor(color);
	}
	
	//request param por añadir un ejemplo, no lo volvere a usar
	@GetMapping("/buscar/color-y-marca")
	public List<Autobus> getAutobusesByColorAndMarca(@RequestParam String color, @RequestParam String modelo) {
	    return alsaService.getAutobusesByColorAndMarca(color, modelo);
	}
	
	@GetMapping("/buscar/capacidad-y-color/{capacidad}/{color}")
	public List<Autobus> buscarPorCapacidadYColor(@PathVariable int capacidad, @PathVariable String color) {
	    return alsaService.buscarAutobusesPorCapacidadYColor(capacidad, color);
	}

		//Tabla RUTA getters
	
	
	@GetMapping("/buscar/ruta/id/{id}")
    public Object buscarRutaById(@PathVariable String id) {
		
        // Convertir a bytes el string
        byte[] idByte = id.getBytes();
        
        
        Ruta ruta = alsaService.buscarRutaById(idByte);
        
        
        if (ruta != null) {
            return ruta;
            
        } else {
        	
            return "la uuid no se encontro o es null";
        }
    }
	
	@GetMapping("/buscar/ruta-origen/{origen}")
	public List<Ruta> getRutaByOrigen(@PathVariable String origen) {
	    return alsaService.getBuscarRutaByOrigen(origen);
	}
	
	@GetMapping("/buscar/ruta-destino/{destino}")
	public List<Ruta> getRutaByDestino(@PathVariable String destino) {
	    return alsaService.getBuscarRutaByDestino(destino);
	}
	
	@GetMapping("/buscar/destino-y-destino/{destino1}/{destino2}")
	public List<Ruta> buscarPorDestinoAyB(@PathVariable String destino1, @PathVariable String destino2) {
	    return alsaService.getBuscarRutasPorDestinoAyB(destino1, destino2);
	}
	
	@GetMapping("/buscar/ruta-distancia/{distancia}")
	public List<Ruta> buscarPorDestinoAyB(@PathVariable BigDecimal distancia) {
	    return alsaService.getBuscarRutasByDistancia(distancia);
	}
	
	@GetMapping("/buscar/origen-y-destino/{origen}/{destino}")
	public List<Ruta> buscarPorOrigenyDestino(@PathVariable String origen, @PathVariable String destino) {
	    return alsaService.getBuscarRutasByOrigenyDestino(origen, destino);
	}
	
	
	//Tabla pasajero getters
	
	@GetMapping("/buscar/pasajero/id/{id}")
    public Object buscarPasajeroById(@PathVariable String id) {
		
        // Convertir a bytes el string
        byte[] idByte = id.getBytes();
        
        
        Pasajero pasajero = alsaService.buscarPasajeroById(idByte);
        
        
        if (pasajero != null) {
            return pasajero;
            
        } else {
        	
            return "la uuid no se encontro o es null";
        }
    }
	
	@GetMapping("/buscar/pasajero/nombre/{nombre}")
	public List<Pasajero> getPasajeroByNombre(@PathVariable String nombre) {
	    return alsaService.getBuscarPasajeroByNombre(nombre);
	}
	
	@GetMapping("/buscar/pasajero/apellido/{apellido}")
	public List<Pasajero> getPasajeroByApellido(@PathVariable String apellido) {
	    return alsaService.getBuscarPasajeroByApellido(apellido);
	}
	
	@GetMapping("/buscar/pasajero/nombre-y-apellido/{nombre}/{apellido}")
	public List<Pasajero> buscarPorNombreyApellido(@PathVariable String nombre, @PathVariable String apellido) {
	    return alsaService.getBuscarPasajeroByNombreyApellido(nombre, apellido);
	}
	
	@GetMapping("/buscar/pasajero/edad-igual/{edad}")
	public List<Pasajero> obtenerPasajeroByEdad(@PathVariable int edad) {
	    return alsaService.getObtenerPasajeroByEdad(edad);
	}
	//Tabla tickets getters

	

	
		@GetMapping("/buscar/ticket/id/{id}")
	    public Object buscarTicketsById(@PathVariable String id) {
			
	        // Convertir a bytes el string
	        byte[] idByte = id.getBytes();
	        
	        
	        Ticket ticket = alsaService.buscarTicketById(idByte);
	        
	        
	        if (ticket  != null) {
	            return ticket ;
	            
	        } else {
	        	
	            return "la uuid no se encontro o es null";
	        }
	    }
		
		@GetMapping("/buscar/ticket/autobus/{idTicket}")
		public Autobus obtenerAutobusPorIdTicket(@PathVariable byte[] idTicket) {
		    return alsaService.buscarAutobusPorIdTicket(idTicket);
		}
		
		@GetMapping("/buscar/ticket-ruta/{idTicket}")
		public Ruta obtenerRutaPorIdTicket(@PathVariable byte[] idTicket) {
		    return alsaService.buscarRutaPorIdTicket(idTicket);
		}
		@GetMapping("/ticket/fecha/{fecha}")
		public List<Ticket> buscarTicketsPorFecha(@PathVariable String fecha) throws ParseException {
			 System.out.println(fecha);
		    return alsaService.getTicketsPorFecha(fecha);
		}
		
		@GetMapping("/buscar/ticket/precio-igual/{precio}")
		public List<Ticket> obtenerPasajeroByEdad(@PathVariable BigDecimal precio) {
		    return alsaService.obtenerTicketByPrecio(precio);
		}
		
		//getters tabla reserva
		@GetMapping("/buscar/reserva/id/{id}")
		public Object buscarReservaById(@PathVariable String id) {
					
			        // Convertir a bytes el string
			        byte[] idByte = id.getBytes();
			        
			        
			        Reserva reserva = alsaService.buscarReservaById(idByte);
			        
			        
			        if (reserva  != null) {
			            return reserva ;
			            
			        } else {
			        	
			            return "la uuid no se encontro o es null";
			        }
			    }
		
		@GetMapping("/buscar/reserva-ticket/{idReserva}")
		public Ticket obtenerTicketByIdReserva(@PathVariable byte[] idReserva) {
		    return alsaService.getBuscarTicketByIdReserva(idReserva);
		}
		@GetMapping("/buscar/reserva-autobus/{idReserva}")
		public Autobus BuscarAutobusByIdReserva(@PathVariable byte[] idReserva) {
		    return alsaService.getBuscarAutobusByIdReserva(idReserva);
		}
		
		@GetMapping("/buscar/reserva-confirmados")
		public List <Reserva> BuscarReservaConfirmada() {
		    return alsaService.getBuscarReservaConfirmada();
		}
		
		@GetMapping("/reserva/reservas-autobus-fecha/{idAutobus}/{fecha}")
		public List<Reserva> buscarReservasAutobus(@PathVariable String idAutobus, @PathVariable String fecha) throws ParseException {
			
			 byte[] idByte = idAutobus.getBytes();
		    return alsaService.getReservasUnAutobus(idByte, fecha);
		}
		
		
		//UPDATES Y deletes Hare uno de cada porque hecho uno hecho todos, no tiene sentido en este ejercicio
		//hacer uno para modelo otro update para placa otro para los dos etc, al final es hacer lo mismo, hago uno con tres parametros y listo
		
		//Autobus modificar modelo placa y color
		
		@PutMapping("/actualizar/autobus/modelo-placa-color/{id}/{modelo}/{placa}/{color}")
	    public Object actualizarAutobusById(@PathVariable String id, @PathVariable String modelo, @PathVariable String placa, @PathVariable String color) {
			
	        // Convertir a bytes el string
	        byte[] idByte = id.getBytes();
	        
	        
	        Autobus autobus = alsaService.actualizarAutobusById(idByte, modelo, placa, color);
	        
	        
	        if (autobus != null) {
	            return autobus;
	            
	        } else {
	        	
	            return "la uuid no se encontro o es null";
	        }
	    }
		
		@DeleteMapping("/eliminar/autobus/id/{id}")
	    public String eliminarAutobusById(@PathVariable String id) {
			
			byte[] idByte;
		    
			   
		    if (id.startsWith("0x")) {
		      
		        String hexUUID = id.substring(2);
		       
		        idByte = hexStringToByteArray(hexUUID);
		    } else {
		       
		        idByte = id.getBytes();
		    }
		    
	        
	        
	        return alsaService.eliminarAutobusById(idByte);
	        
	        
	        
	    }
		@DeleteMapping("/eliminar/persona/id/{id}")
	    public String eliminarPersonaById(@PathVariable String id) {
			
	        // Convertir a bytes el string
	        byte[] idByte = id.getBytes();
	        return alsaService.eliminarPersonaById(idByte);
	    }
		
		 @PostMapping("/add/autobus")
		 
			public Autobus postAutobusParam(@RequestParam String modelo, @RequestParam int pasajeros, @RequestParam String placa, @RequestParam String color)
			{
			 System.out.println(modelo + pasajeros + placa + color);
				return this.alsaService.postAutobusParam(modelo, pasajeros, placa, color);
			}
		 
		 @PostMapping("/add/ticket")
		 
			public Ticket postTicketParam(@RequestParam String idAutobus, @RequestParam String idRuta, @RequestParam String fechaViaje, @RequestParam BigDecimal precio) throws ParseException
			{
			 
			 byte[] idByte;
			    
			   
			    if (idAutobus.startsWith("0x")) {
			      
			        String hexUUID = idAutobus.substring(2);
			       
			        idByte = hexStringToByteArray(hexUUID);
			    } else {
			       
			        idByte = idAutobus.getBytes();
			    }
			    Autobus autobus = alsaService.buscarAutobusById(idByte);
			    byte[] idByteRuta = idRuta.getBytes();
		        
		        
		        Ruta ruta = alsaService.buscarRutaById(idByteRuta);
				return this.alsaService.postTicketParam(autobus, ruta, fechaViaje, precio);
			}
		
		
		
			

	
}