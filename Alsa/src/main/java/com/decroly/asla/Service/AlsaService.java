package com.decroly.asla.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.stereotype.Service;

import com.decroly.asla.Model.Autobus;
import com.decroly.asla.Model.Pasajero;
import com.decroly.asla.Model.Reserva;
import com.decroly.asla.Model.Ruta;
import com.decroly.asla.Model.Ticket;
import com.decroly.asla.Repository.AutobusRepository;
import com.decroly.asla.Repository.PasajeroRepository;
import com.decroly.asla.Repository.ReservaRepository;
import com.decroly.asla.Repository.RutaRepository;
import com.decroly.asla.Repository.TicketRepository;







@Service
public class AlsaService {

	
	
	private final AutobusRepository autobusRepository;
	private final RutaRepository rutaRepository;
	private final PasajeroRepository pasajeroRepository;
	private final TicketRepository ticketRepository;
	private final ReservaRepository reservaRepository;
	
	public AlsaService(AutobusRepository autobusRepository, RutaRepository rutaRepository, PasajeroRepository pasajeroRepository, TicketRepository ticketRepository, ReservaRepository reservaRepository)
	{
		this.autobusRepository = autobusRepository;
		this.rutaRepository = rutaRepository;
		this.pasajeroRepository = pasajeroRepository;
		this.ticketRepository = ticketRepository;
		this.reservaRepository = reservaRepository;
	

	}
	
	//server getter autobus table

	public Autobus buscarAutobusById(byte[] id) {
	    Autobus autobus = autobusRepository.findById(id).orElse(null);
	    return autobus;
	}
	
	public List<Autobus> getAutobusesAll()
	{
		return this.autobusRepository.findAll();
		
	}
	
	  public List<Autobus> getBuscarAutobusesByModelo(String modelo) {
		 
	        return buscarPorModelo(modelo);
	    }
	  
	  public List<Autobus> obtenerAutobusByCapacidad_Entre(int capacidad1 , int capacidad2){
			 
	        return buscarByCapacidadEntre(capacidad1, capacidad2);
	    }
	  
	  public List<Autobus> obtenerAutobusByCapacidadMayor(int capacidad){
			 
	        return buscarByCapacidadMayor(capacidad);
	    }
	  
	  public List<Autobus> obtenerAutobusByCapacidadMenor(int capacidad){
			 
	        return buscarByCapacidadMenor(capacidad);
	    }
	  public List<Autobus> obtenerAutobusByCapacidadIgual(int capacidad){
			 
	        return buscarByCapacidadIgual(capacidad);
	    }
	  
	  public List<Autobus> getBuscarAutobusesByPlaca(String Placa) {
			 
	        return buscarPorPlaca(Placa);
	    }
	  
	  public List<Autobus> getAutobusesByColor(String color) {
		    return buscarPorColor(color);
		}
	  
	  public List<Autobus> getAutobusesByColorAndMarca(String color, String placa) {
		    return buscarPorColorYMarca(color, placa);
		}
	  
	  public List<Autobus> buscarAutobusesPorCapacidadYColor(int capacidad, String color) {
		   
		    return buscarPorCapacidadYColor(capacidad, color);
		}
	  
	  //service getter ruta trable
	  public Ruta buscarRutaById(byte[] id) {
		    Ruta ruta = rutaRepository.findById(id).orElse(null);
		    return ruta;
		}

	  public List<Ruta> getBuscarRutaByOrigen(String origen) {
			 
	        return buscarPorOrigen(origen);
	    }
	  
	  public List<Ruta> getBuscarRutaByDestino(String destino) {
			 
	        return buscarPorDestino(destino);
	    }

	  public List<Ruta> getBuscarRutasPorDestinoAyB(String destino1, String destino2) {
		    return buscarPorDestinoAyB(destino1, destino2);
		}
	  
	  public List<Ruta> getBuscarRutasByDistancia(BigDecimal distancia) {
		    return buscarPorDistancia(distancia);
		}
	  public List<Ruta> getBuscarRutasByOrigenyDestino(String origen, String destino) {
		    return buscarPorOrigenyDestino(origen, destino);
		}
	  
	  
	  
	  //serrvice getters pasajero table
	  
	  public Pasajero buscarPasajeroById(byte[] id) {
		    Pasajero pasajero = pasajeroRepository.findById(id).orElse(null);
		    return pasajero;
		}
	  
	  public List<Pasajero> getBuscarPasajeroByNombre(String nombre) {
			 
	        return buscarPasajeroByNombre(nombre);
	    }
	  
	  public List<Pasajero> getBuscarPasajeroByApellido(String apellido) {
			 
	        return buscarPasajeroByApellido(apellido);
	    }
	  
	  public List<Pasajero> getBuscarPasajeroByNombreyApellido(String nombre, String apellido) {
		    return buscarPorNombreyApellido(nombre, apellido);
		}
	  
	  public List<Pasajero> getObtenerPasajeroByEdad(int edad){
			 
	        return buscarPasajeroByEdad(edad);
	    }
	  
	  //getter tablkla ticket
	  
	  public Ticket buscarTicketById(byte[] id) {
		    Ticket tickets = ticketRepository.findById(id).orElse(null);
		    return tickets;
		}
	  
	  public Autobus buscarAutobusPorIdTicket(byte[] idTicket) {
		  
		    Ticket ticket = ticketRepository.findById(idTicket).orElse(null);
		    
		    if (ticket != null) {
		        return ticket.getIdAutobus();
		    }
		    
		    return null;
		}
	  
	  public Ruta buscarRutaPorIdTicket(byte[] idTicket) {
		  
		    Ticket ticket = ticketRepository.findById(idTicket).orElse(null);
		    
		    if (ticket != null) {
		        return ticket.getIdRuta();
		    }
		    
		    return null;
		}
	  
	  public List<Ticket> getTicketsPorFecha(String fecha) throws ParseException {
			 
	        return formateador(fecha);
	    }
	  
	  public List<Ticket> obtenerTicketByPrecio(BigDecimal precio){
			 
	        return buscarTicketByPrecio(precio);
	    }
	  
	 
	  //service tabla reserva getters
	  
	  public Reserva buscarReservaById(byte[] id) {
		    Reserva reservas = reservaRepository.findById(id).orElse(null);
		    return reservas;
		}


	  public Ticket getBuscarTicketByIdReserva(byte[] idReserva) {
		  
		  Reserva reserva = reservaRepository.findById(idReserva).orElse(null);
		    
		    if (reserva != null) {
		        return reserva.getIdTicket();
		    }
		    
		    return null;
		}
	  
		public Autobus getBuscarAutobusByIdReserva(byte[] idReserva) {
				  
				  Reserva reserva = reservaRepository.findById(idReserva).orElse(null);
				    
				    if (reserva != null) {
				        Ticket ticket = reserva.getIdTicket();
				        return ticket.getIdAutobus();
				    }
				    
				    return null;
				}
		
		public List<Reserva> getBuscarReservaConfirmada(){
			 
	        return BuscarReservaConfirmada();
	    }
		
		public List<Reserva> getReservasUnAutobus(byte[] idAutobus, String fecha) throws ParseException{
			
			Date fechaF = formateador2(fecha);
			 
	        return buscarReservasAutobus(idAutobus, fechaF);
	    }
	  
		
		//service updates
		
		public Autobus actualizarAutobusById(byte[] id, String modelo, String placa, String color) {
			
			if (id == null) {
				return null;
			}
			String nombreLimpio1 = modelo.trim();
			String nombreLimpio2 = placa.trim();
			String nombreLimpio3 = color.trim();
			System.out.println("hola");
		    Autobus autobus = autobusRepository.findById(id).orElse(null);
		    if (nombreLimpio1 != "" && nombreLimpio2 != "" && nombreLimpio3 != "" ) {
		    autobus.setColor(nombreLimpio1);
		    autobus.setModelo(nombreLimpio2);
		    autobus.setPlaca(nombreLimpio3);
		    autobusRepository.save(autobus);
		    return autobus;
		    }
		    return null;
		}
		
		public String eliminarAutobusById(byte[] id) {
					
					if (id == null) {
						return null;
					}
					
				
				    Autobus autobus = autobusRepository.findById(id).orElse(null);
				    
				   if (autobus != null) {
					   autobusRepository.delete(autobus);
					    return "Eliminado";
				}
				   else {
					   return "no encontrado";
				   }
				    
				
				}

			public String eliminarPersonaById(byte[] id) {
				
				if (id == null) {
					return null;
				}
			    Pasajero pasajero = pasajeroRepository.findById(id).orElse(null);    
			   if (pasajero != null) {
				   pasajeroRepository.delete(pasajero);
				    return "Eliminado";
			}
			   else {
				   return "no encontrado";
			   }
			    
			
			}
			
			public Autobus postAutobusParam(String modelo, int pasajeros, String placa, String color)
			{
				UUID uuid = UUID.randomUUID();
				Autobus autobus = new Autobus (uuid, modelo, pasajeros, placa, color);
				if (autobus != null) {
					this.autobusRepository.save(autobus);
				}
				
				return autobus;
				
				
				
			}
			
			public Ticket postTicketParam( Autobus idAutobus, Ruta idRuta, String fechaViaje, BigDecimal precio) throws ParseException
			{
				Date fechaF = formateador2(fechaViaje);
				
				UUID uuid = UUID.randomUUID();
				Ticket ticket = new Ticket (uuid, idAutobus, idRuta,fechaF, precio);
				if (ticket != null) {
					this.ticketRepository.save(ticket);
				}
				
				return ticket;
				
				
				
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		public List<Reserva> buscarReservasAutobus(byte[] idAutobus, Date fecha) {
	        List<Reserva> allReservas = reservaRepository.findAll();
	        List<Reserva> reservasAutobus = new ArrayList<>();
	        
	        for (Reserva reserva : allReservas) {
	            
	        	//de algo me sirvio saber que devuelve un array el getid, array equals
	            if (Arrays.equals(reserva.getIdTicket().getIdAutobus().getId(), idAutobus) && 
	                
	                reserva.getIdTicket().getFechaViaje().compareTo(fecha) == 0) {
	            	
	                reservasAutobus.add(reserva);
	            }
	        }
	        
	        return reservasAutobus;
	    }
	  
	  
	

	  //lo copie de otro proyecto el conversor de date, que se me olvido poner long para date y use date en su lugar
	  //String[] partesFecha = fechaString.split("-"); la / me da problemas porque piensa que es otra url si hago 20/1/1988 pr ejemplo
	  private List<Ticket> formateador(String fechaString) throws ParseException {
		  System.out.println(fechaString);
		  List<Ticket> alltickets = ticketRepository.findAll();
		    List<Ticket> ticketsporDates = new ArrayList<>();
	     
	        String[] partesFecha = fechaString.split("-");
	        
	     
	        int dia = Integer.parseInt(partesFecha[0]);
	        int mes = Integer.parseInt(partesFecha[1]) - 1; 
	        int ano = Integer.parseInt(partesFecha[2]);
	       
	      
	     
			Date fecha = new Date(ano - 1900, mes, dia);
			 System.out.println(fecha);
			 
		    for (Ticket tickets : alltickets) {
		        if (tickets.getFechaViaje().equals(fecha)) {
		        	ticketsporDates.add(tickets);
		        }
		    }
		    
		    return ticketsporDates;
	  
	        
	    
	    }
	  //no me apetecia encapsular el formatewador que ya lo tenia bien, lo encapsulo ahora
	  
	  private Date formateador2(String fechaString) throws ParseException {
		  System.out.println(fechaString);
	     
	        String[] partesFecha = fechaString.split("-");
	        
	     
	        int dia = Integer.parseInt(partesFecha[0]);
	        int mes = Integer.parseInt(partesFecha[1]) - 1; 
	        int ano = Integer.parseInt(partesFecha[2]);
	       
	      
	     
			Date fecha = new Date(ano - 1900, mes, dia);
		    return fecha;

	    }
	  
	  private List<Autobus> buscarPorCapacidadYColor(int capacidad, String color) {
		  List<Autobus> allAutobuses = autobusRepository.findAll();
		    List<Autobus> autobusesPorCapacidadYColor = new ArrayList<>();

		    for (Autobus autobus : allAutobuses) {
		        if (autobus.getCapacidadPasajeros() == capacidad && autobus.getColor().equalsIgnoreCase(color)) {
		            autobusesPorCapacidadYColor.add(autobus);
		        }
		    }

		    return autobusesPorCapacidadYColor;
		}
	  private List<Autobus> buscarPorColorYMarca(String color, String placa) {
		    List<Autobus> allAutobuses = autobusRepository.findAll();
		    List<Autobus> autobusesByColorYMarca = new ArrayList<>();
		    
		    for (Autobus autobus : allAutobuses) {
		        if (autobus.getColor().equalsIgnoreCase(color) && autobus.getPlaca().equalsIgnoreCase(placa)) {
		            autobusesByColorYMarca.add(autobus);
		        }
		    }
		    
		    return autobusesByColorYMarca;
		}
	  
	  private List<Autobus> buscarPorColor(String color) {
		  
		    List<Autobus> allAutobuses = autobusRepository.findAll();
		    
		    List<Autobus> autobusesByColor = new ArrayList<>();
		    
		    for (Autobus autobus : allAutobuses) {
		    	
		        if (autobus.getColor().equalsIgnoreCase(color)) {
		        	
		            autobusesByColor.add(autobus);
		        }
		    }
		    
		    return autobusesByColor;
		}
	  
	  
	  private List<Autobus> buscarByCapacidadIgual(int capacidad) {
			
			 List<Autobus> AllAutobuses = autobusRepository.findAll();
			
	        List<Autobus> allAutobusesByCapacidad = new ArrayList<>();
	        
	        
	        for (Autobus autobus : AllAutobuses) {
	        	
	            if (autobus.getCapacidadPasajeros() == capacidad ) {
	            	
	            	allAutobusesByCapacidad.add(autobus);
	            }
	        }
	        return allAutobusesByCapacidad;
	        }
	  
	  
	  
	  
	  
	  
	  private List<Autobus> buscarByCapacidadMenor(int capacidad) {
			
			 List<Autobus> AllAutobuses = autobusRepository.findAll();
			
	        List<Autobus> allAutobusesByCapacidad = new ArrayList<>();
	        
	        
	        for (Autobus autobus : AllAutobuses) {
	        	
	            if (autobus.getCapacidadPasajeros() < capacidad ) {
	            	
	            	allAutobusesByCapacidad.add(autobus);
	            }
	        }
	        return allAutobusesByCapacidad;
	        }
	  
	  private List<Autobus> buscarByCapacidadMayor(int capacidad) {
			
			 List<Autobus> AllAutobuses = autobusRepository.findAll();
			
	        List<Autobus> allAutobusesByCapacidad = new ArrayList<>();
	        
	        
	        for (Autobus autobus : AllAutobuses) {
	        	
	            if (autobus.getCapacidadPasajeros() > capacidad ) {
	            	
	            	allAutobusesByCapacidad.add(autobus);
	            }
	        }
	        return allAutobusesByCapacidad;
	        }
	  
	  private List<Autobus> buscarByCapacidadEntre(int capacidad1, int capacidad2) {
			
			 List<Autobus> AllAutobuses = autobusRepository.findAll();
			
	        List<Autobus> allAutobusesByCapacidad = new ArrayList<>();
	        
	        
	        for (Autobus autobus : AllAutobuses) {
	        	
	            if (autobus.getCapacidadPasajeros() > capacidad1 && autobus.getCapacidadPasajeros() < capacidad2 ) {
	            	
	            	allAutobusesByCapacidad.add(autobus);
	            }
	        }
	        
	        return allAutobusesByCapacidad;
	    }
		
	
	
	private List<Autobus> buscarPorModelo(String modelo) {
		
		 List<Autobus> AllAutobuses = autobusRepository.findAll();
		
        List<Autobus> allAutobusesByModelo = new ArrayList<>();
        
        
        for (Autobus autobus : AllAutobuses) {
        	
            if (autobus.getModelo().equals(modelo)) {
            	
            	allAutobusesByModelo.add(autobus);
            }
        }
        
        return allAutobusesByModelo;
    }
	private List<Autobus> buscarPorPlaca(String placa) {
		
		 List<Autobus> AllAutobuses = autobusRepository.findAll();
		
       List<Autobus> allAutobusesByPlaca = new ArrayList<>();
       
       
       for (Autobus autobus : AllAutobuses) {
       	
           if (autobus.getPlaca().equals(placa)) {
           	
           	allAutobusesByPlaca.add(autobus);
           }
       }
       
       return allAutobusesByPlaca;
   }
	
	private List<Ruta> buscarPorOrigen(String origen) {
		
		 List<Ruta> Allrutas = rutaRepository.findAll();
		
       List<Ruta> allRutasByOrigen = new ArrayList<>();
       
       
       for (Ruta rutas : Allrutas) {
       	
           if (rutas.getOrigen().equals(origen)) {
           	
           	allRutasByOrigen.add(rutas);
           }
       }
       
       return allRutasByOrigen;
   }
	
	private List<Ruta> buscarPorDestino(String destino) {
		
		 List<Ruta> Allrutas = rutaRepository.findAll();
		
      List<Ruta> allRutasByDestino = new ArrayList<>();
      
      
      for (Ruta rutas : Allrutas) {
      	
          if (rutas.getDestino().equals(destino)) {
          	
          	allRutasByDestino.add(rutas);
          }
      }
      
      return allRutasByDestino;
  }
	
	
	//Regular expreon y regexp, para completar requisitos
	private List<Ruta> buscarPorDestinoAyB(String destino1, String destino2)throws PatternSyntaxException  {
		
		String regex = "^[a-zA-Z\\s]+$"; 

	    try {
	    
	        Pattern pattern = Pattern.compile(regex);
	        if (!pattern.matcher(destino1).matches() || !pattern.matcher(destino2).matches()) {
	            throw new PatternSyntaxException("Destinos no válidos", regex, -1);
	        }
	    } catch (PatternSyntaxException e) {
	
	        System.err.println("Error: " + e.getDescription());
	        return Collections.emptyList();
	    }

	    List<Ruta> allRutas = rutaRepository.findAll();
	    List<Ruta> rutasbydestinoAyB = new ArrayList<>();
	    
	    
	    
	    for (Ruta rutas : allRutas) {
	        if (rutas.getDestino().equalsIgnoreCase(destino1) || rutas.getDestino().equalsIgnoreCase(destino2)) {
	        	rutasbydestinoAyB.add(rutas);
	        }
	    }
	    
	    return rutasbydestinoAyB;
	}
	
	 
	  private List<Ruta> buscarPorDistancia(BigDecimal distancia) {
			
			 List<Ruta> Allrutas= rutaRepository.findAll();
			
	        List<Ruta> allrutasByDistancia = new ArrayList<>();
	        System.out.println("Estoy aqui" + distancia);
	        
	        
	        for (Ruta rutas: Allrutas) {
	        	
	            if (rutas.getDistanciaKm().equals(distancia) ) {
	            	
	            	allrutasByDistancia.add(rutas);
	            }
	        }
	        return allrutasByDistancia;
	        }
	  
	  private List<Ruta> buscarPorOrigenyDestino(String origen, String destino) {
		    List<Ruta> allRutas = rutaRepository.findAll();
		    List<Ruta> rutasbyOrigenyDestino = new ArrayList<>();
		    
		    for (Ruta rutas : allRutas) {
		        if (rutas.getOrigen().equalsIgnoreCase(origen) && rutas.getDestino().equalsIgnoreCase(destino)) {
		        	rutasbyOrigenyDestino.add(rutas);
		        }
		    }
		    
		    return rutasbyOrigenyDestino;
		}
	  
	  private List<Pasajero> buscarPasajeroByNombre(String nombre) {
			
			 List<Pasajero> AllPasajeros = pasajeroRepository.findAll();
			
	        List<Pasajero> allPasajerosByNombre = new ArrayList<>();
	        
	        
	        for (Pasajero pasajeros : AllPasajeros) {
	        	
	            if (pasajeros.getNombre().equals(nombre)) {
	            	
	            	allPasajerosByNombre.add(pasajeros);
	            }
	        }
	        
	        return allPasajerosByNombre;
	    }
	  private List<Pasajero> buscarPasajeroByApellido(String apellido) {
			
			 List<Pasajero> AllPasajeros = pasajeroRepository.findAll();
			
	        List<Pasajero> allPasajerosByApellido = new ArrayList<>();
	        
	        
	        for (Pasajero pasajeros : AllPasajeros) {
	        	
	            if (pasajeros.getApellido().equals(apellido)) {
	            	
	            	allPasajerosByApellido.add(pasajeros);
	            }
	        }
	        
	        return allPasajerosByApellido;
	    }
	  
	  
	  private List<Pasajero> buscarPorNombreyApellido(String nombre, String apellido) {
		    List<Pasajero> allPasajeros = pasajeroRepository.findAll();
		    List<Pasajero> pasajerosNombreyApellido = new ArrayList<>();
		    
		    for (Pasajero pasajeros : allPasajeros) {
		        if (pasajeros.getNombre().equalsIgnoreCase(nombre) && pasajeros.getApellido().equalsIgnoreCase(apellido)) {
		        	pasajerosNombreyApellido.add(pasajeros);
		        }
		    }
		    
		    return pasajerosNombreyApellido;
		}

	  private List<Pasajero> buscarPasajeroByEdad(int edad) {
			
			 List<Pasajero> AllPasajeros = pasajeroRepository.findAll();
			
	        List<Pasajero> allPasajerosByEdad = new ArrayList<>();
	        
	        
	        for (Pasajero pasajeros : AllPasajeros) {
	        	
	            if (pasajeros.getEdad() == edad ) {
	            	
	            	allPasajerosByEdad.add(pasajeros);
	            }
	        }
	        return allPasajerosByEdad;
	        }
	  
	  
	  private List<Ticket> buscarTicketByPrecio(BigDecimal precio) {
			
			 List<Ticket> AllTickets = ticketRepository.findAll();
			
	        List<Ticket> allTicketsByPrecio = new ArrayList<>();
	        
	        
	        for (Ticket tickets : AllTickets) {
	        	
	            if (tickets.getPrecio().compareTo(precio) == 0 ) {
	            	
	            	allTicketsByPrecio.add(tickets);
	            }
	        }
	        return allTicketsByPrecio;
	        }
	  private List<Reserva> BuscarReservaConfirmada() {
		  
		  	String confirmada = "confirmado";
		  
		    List<Reserva> allreservas = reservaRepository.findAll();
		    
		    List<Reserva> reservasConfirmadas = new ArrayList<>();
		    
		    for (Reserva reservas : allreservas) {
		    	
		        if (reservas.getEstado().equalsIgnoreCase(confirmada)) {
		        	
		        	reservasConfirmadas.add(reservas);
		        }
		    }
		    
		    return reservasConfirmadas;
		}
	  
	  
}
