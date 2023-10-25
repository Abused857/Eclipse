package com.decroly.Game.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.decroly.Game.Model.Consola;
import com.decroly.Game.Model.Genero;
import com.decroly.Game.Model.Perifericos;
import com.decroly.Game.Model.Plataforma;
import com.decroly.Game.Model.Producto;
import com.decroly.Game.Model.TipoDispositivo;
import com.decroly.Game.Model.VideoJuego;

@Repository
public class Gestion {

	private HashMap<String, Producto> productos = new HashMap<>();
	
	File path = new File("./src/main/java/com/decroly/Game/Repository/game.txt");
	
	
	
	public Gestion()
	{
		
		/*
		this.productos = new HashMap<>();
		
		Consola c = new Consola ("nombre1", "01", "descripcion1", 100, 120, "edicion 1", false);
		
		
		this.productos.put("01", c);
		
		*/
		
		
	
	}
	
	
	
	public void crearProducto(String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion) 
	
	{
		
		Producto p = new Producto(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion);
		agregarProducto(p);
	}
	
	
	public void crearConsola(String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion, Plataforma plataforma, boolean isNuevo)
	
	
	{
		Consola c = new Consola(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, plataforma, isNuevo);
		agregarProducto(c);
	}
	
	
	public void crearPerifericos(String nombre, String serialNumber, String descripcion, int precio,
			long fechaLanzamiento, String edicion, TipoDispositivo tipoDispositivo, boolean isNuevo,
			boolean isWireless, String marca) 
	
	
	{
	
		Perifericos pe = new Perifericos (nombre, serialNumber, descripcion, precio,
			fechaLanzamiento, edicion, tipoDispositivo, isNuevo,
			isWireless, marca);
		agregarProducto(pe);
	}
	
	public void agregarProducto(Producto p) {
		
		productos = cargarProductos();
		
		if (p != null) {
			
			productos.put(p.getSerialNumber(), p);
			guardarProducto();
			
		}else {
			System.out.println("Objeto vacío");
		}  
	}
	
	public HashMap<String, Producto> cargarProductos() {

        productos.clear();
        
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            while (true) {

                Object obj = ois.readObject();

                if (obj instanceof Producto) {
                	
                    Producto producto = (Producto) obj;
                    
                  productos.put(producto.getSerialNumber(), producto);
                }
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo, se terminó la lectura
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        return productos;
    }
	
	public void guardarProducto() {
		
		
        ObjectOutputStream oos = null;
        

        

        try {

            oos = new ObjectOutputStream(new FileOutputStream(path, false));
            

            for (String s : productos.keySet()) {
            	
                oos.writeObject(productos.get(s));

            }
        } catch (IOException e) {

            System.out.println("Error al escribir");

            e.printStackTrace();
        } finally {
            if (oos != null) {
                	try {
                		oos.close();

                		} 		catch (IOException e) {

                    			System.out.println("Error al cerrar el objeto de escritura");

                    			e.printStackTrace();
                				}
            }
        }
    }
	
	public Producto devolverId(String serialNumber) {
	    List<Producto> productos = devolverAllProductos(); 

	    for (Producto producto : productos) {
	        if (producto.getSerialNumber().equals(serialNumber)) {
	            return producto;
	        }
	    }

	    return null; 
	}

	
	
	//devolver consola/producto/videojuegoperifeco metodo0s
	public List<VideoJuego> devolverVideoJuegos() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		List <VideoJuego> videoJuegos = new ArrayList<VideoJuego>();		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);			
	         String linea;	         
	         while((linea=br.readLine())!=null) {
	        	 String [] partes = linea.split(",");
	        	 if (partes.length == 10 && partes[1].contains("V-")) {
//nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, genero, plataforma, boolean isDigital, boolean isNuevo
	                    String nombre = partes[0].trim();
	                    String serialNumber = partes[1].trim();
	                    String descripcion = partes[2].trim();
	                    String precio1 = partes [3].trim();
	                    int precio = Integer.parseInt(precio1);
	                    String fecha1 = partes[4].trim();
	                    long fechaLanzamiento = Long.parseLong(fecha1);
	                    String edicion = partes[5].trim();
	                    String genero1 = partes[6].trim();
	                    Genero genero = Genero.valueOf(genero1);
	                    String plataforma1 = partes[7].trim();
	                    Plataforma plataforma = Plataforma.valueOf(plataforma1);
	                    String digital = partes[8].trim();
	                    Boolean isDigital = Boolean.valueOf(digital);
	                    String nuevo = partes [9].trim();
	                    Boolean isNuevo = Boolean.valueOf(nuevo);
	                    VideoJuego videoJuego = new VideoJuego(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, genero, plataforma, isDigital, isNuevo);
	                    videoJuegos.add(videoJuego);
	                   
	                } 
	        	
	         } 
	         System.out.println("Stream cerrado");
	         fr.close();
        	 br.close();
	        	
		}catch(Exception e){
	             e.printStackTrace();
	          }
	
		return videoJuegos;
	}
	
	public List <Consola> devolverConsolas(){
		
		List <Consola> consolas= new ArrayList<Consola>();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String linea;		
			while ((linea = br.readLine())!=null) {
//nombre, serialNumber, descripcion, int precio, long fechaLanzamiento, String edicion, boolean isNuevo				
				String [] partes = linea.split(",");
					if (partes.length == 8 && partes [1].contains("C-")) {
						
						String nombre = partes[0].trim();
						String serialNumber = partes[1].trim();
						String descripcion = partes[2].trim();
						int precio = Integer.valueOf(partes[3].trim());
						long fechaLanzamiento = Long.valueOf(partes[4].trim());
						String edicion = partes[5].trim();
						Plataforma plataforma = Plataforma.valueOf(partes[6].trim());
						Boolean isNuevo = Boolean.valueOf(partes[7].trim());
						
						Consola consola = new Consola(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, plataforma, isNuevo);
						consolas.add(consola);
					}
			}
			fr.close();
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consolas;
	}
	
	public List <Perifericos> devolverAllPerifericos(){
		
		FileReader fr = null;
		BufferedReader br = null;
		HashMap <String, Perifericos> perifericos = new HashMap<String, Perifericos>();
	
		
		String linea;
		
		try {
			
			fr = new FileReader (path);
			br = new BufferedReader(fr);
			
			
			while((linea = br.readLine())!= null) {
				
				String partes [] = linea.split(",");
				
				if (partes.length == 10 && partes[1].contains("Pe-")) {
					
	/*
	 *nombre, String serialNumber, String descripcion, int precio,
							long fechaLanzamiento, String edicion, TipoDispositivo tipoDispositivo, boolean isNuevo,
							boolean isWireless, String marca
	 */
					
					
					String nombre = partes[0].trim();
					String serialNumber = partes[1].trim();
					String descripcion = partes [2].trim();
					int precio = Integer.valueOf(partes[3].trim());
					long fechaLanzamiento = Long.valueOf(partes[4].trim());
					String edicion = partes[5].trim();
					TipoDispositivo tipoDispositivo = TipoDispositivo.valueOf(partes[6].trim());
					boolean isNuevo = Boolean.valueOf(partes[7].trim());
					boolean isWireless = Boolean.valueOf(partes[8].trim());
					String marca = partes[9].trim();
					
					Perifericos periferico = new Perifericos(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, tipoDispositivo, isNuevo, isWireless, marca);
					
					
					perifericos.put(periferico.getSerialNumber(), periferico);

				}	
			}
			
			fr.close();
			br.close();	
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return perifericos.values().stream().toList();
		}
	
	
	public List <Producto> devolverProductos(){
		FileReader fr = null;
		BufferedReader br = null;
		
		HashMap <String, Producto> productos = new HashMap <>();
		
		String linea;
		
		try {
			
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			while((linea = br.readLine())!= null) {
				
				String [] partes = linea.split(", ");
				
				if (partes.length == 6 && partes[1].contains("P-")) {
					
					//String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion
					
					String nombre = partes[0].trim();
					String serialNumber = partes[1].trim();
					String descripcion = partes[2].trim();
					int precio = Integer.valueOf(partes[3].trim());
					long fechaLanzamiento = Long.valueOf(partes[4].trim());
					String edicion = partes[5].trim();
					
					Producto producto = new Producto(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion);
					
					productos.put(producto.getSerialNumber(), producto);

				}
	
			}
	fr.close();
	br.close();
		} catch (Exception e) {
		
		}

		return productos.values().stream().toList();
	}
			
		
	public List <Producto> devolverAllProductos(){
		
		FileReader fr = null;
		BufferedReader br = null;
		List <Producto> productos = new ArrayList<>();
		
		String linea;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			while((linea = br.readLine())!=null) {
			String [] partes = linea.split(", ");	
			if (partes.length == 6 && partes[1].contains("P-")) {
				
				//String nombre, String serialNumber, String descripcion, int precio, long fechaLanzamiento, String edicion
				
				String nombre = partes[0].trim();
				String serialNumber = partes[1].trim();
				String descripcion = partes[2].trim();
				int precio = Integer.valueOf(partes[3].trim());
				long fechaLanzamiento = Long.valueOf(partes[4].trim());
				String edicion = partes[5].trim();
				
				Producto producto = new Producto(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion);
				
				productos.add(producto);
			}
			
			
			if (partes.length == 10 && partes[1].contains("Pe-")) {
				
				/*
				 *nombre, String serialNumber, String descripcion, int precio,
										long fechaLanzamiento, String edicion, TipoDispositivo tipoDispositivo, boolean isNuevo,
										boolean isWireless, String marca
				 */
								
								
						String nombre = partes[0].trim();
						String serialNumber = partes[1].trim();
						String descripcion = partes [2].trim();
						int precio = Integer.valueOf(partes[3].trim());
						long fechaLanzamiento = Long.valueOf(partes[4].trim());
						String edicion = partes[5].trim();
						TipoDispositivo tipoDispositivo = TipoDispositivo.valueOf(partes[6].trim());
						boolean isNuevo = Boolean.valueOf(partes[7].trim());
						boolean isWireless = Boolean.valueOf(partes[8].trim());
						String marca = partes[9].trim();
								
						Perifericos periferico = new Perifericos(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, tipoDispositivo, isNuevo, isWireless, marca);
								
								
						productos.add(periferico);

					}
			if (partes.length == 8 && partes [1].contains("C-")) {
				
				String nombre = partes[0].trim();
				String serialNumber = partes[1].trim();
				String descripcion = partes[2].trim();
				int precio = Integer.valueOf(partes[3].trim());
				long fechaLanzamiento = Long.valueOf(partes[4].trim());
				String edicion = partes[5].trim();
				Plataforma plataforma = Plataforma.valueOf(partes[6].trim());
				Boolean isNuevo = Boolean.valueOf(partes[7].trim());
				
				Consola consola = new Consola(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, plataforma, isNuevo);
				productos.add(consola);
			}
			
			if (partes.length == 10 && partes[1].contains("V-")) {
				//nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, genero, plataforma, boolean isDigital, boolean isNuevo
					String nombre = partes[0].trim();
					String serialNumber = partes[1].trim();
					String descripcion = partes[2].trim();
					String precio1 = partes [3].trim();
					int precio = Integer.parseInt(precio1);
					String fecha1 = partes[4].trim();
					long fechaLanzamiento = Long.parseLong(fecha1);
					String edicion = partes[5].trim();
					String genero1 = partes[6].trim();
					Genero genero = Genero.valueOf(genero1);
					String plataforma1 = partes[7].trim();
					Plataforma plataforma = Plataforma.valueOf(plataforma1);
					String digital = partes[8].trim();
					Boolean isDigital = Boolean.valueOf(digital);
					String nuevo = partes [9].trim();
					Boolean isNuevo = Boolean.valueOf(nuevo);
					VideoJuego videoJuego = new VideoJuego(nombre, serialNumber, descripcion, precio, fechaLanzamiento, edicion, genero, plataforma, isDigital, isNuevo);
					productos.add(videoJuego);
					                   
					                } 

			}
			fr.close();
			br.close();
		} catch (Exception e) {
		
		}
		
		System.out.println(productos.toString());
		return productos;

	} 
	
	//METODOS PARA DEVOLVER DE TODOS LOS PRODUCTOS
	
	public Producto devolverNombreAllProductos(String nombre) {
	    List<Producto> productos = devolverAllProductos();

	    for (Producto producto : productos) {
	        if (producto.getNombre().equals(nombre)) {
	        	
	                return producto; 
	    }
	    }
	    return null; 
	}
	
	public List<Producto> filtrarProductosPorPrecioMenor(int precio) {
	    List<Producto> productos = devolverAllProductos();
	    List<Producto> productosFiltrados = new ArrayList<>();

	    for (Producto producto : productos) {

	        if (producto.getPrecio() <= precio) {
	            productosFiltrados.add(producto);
	        } 
	    }

	    return productosFiltrados;
	}
	public List<Producto> filtrarProductosPorPrecioMayor(int precio) {
	    List<Producto> productos = devolverAllProductos();
	    List<Producto> productosFiltrados = new ArrayList<>();

	    for (Producto producto : productos) {

	        if (producto.getPrecio() >= precio) {
	            productosFiltrados.add(producto);
	        } 
	    }

	    return productosFiltrados;
	}
	public List<Producto> filtrarProductosPorPrecioIgual(int precio) {
	    List<Producto> productos = devolverAllProductos();
	    List<Producto> productosFiltrados = new ArrayList<>();

	    for (Producto producto : productos) {

	        if (producto.getPrecio() == precio) {
	            productosFiltrados.add(producto);
	        } 
	    }

	    return productosFiltrados;
	}
	
	public List<Producto> devolverEdicion(String edicion) {
	    List<Producto> productos = devolverAllProductos();
	    
	    //en vez de crear una lista de filtro quiero probar a borrar los que no cumplan la condicion
	    //puesto que aqui cargo la lista para cada busqueda es mas rapido recorrer una vez la lista borrando
	    //lo que no haga match, en vez de pasarlo a la lista filtro y volverla a recorrer
	    //aparte de que no me acordaba del codigo del iterator para refrescarlo
	    Iterator<Producto> iter = productos.iterator();
	    
	    while (iter.hasNext()) {
	        Producto producto = iter.next();
	        if (!producto.getEdicion().equals(edicion)) {
	            iter.remove();
	        }
	    }
		return productos;
	   }
/*
	public List<Producto> filtrarProductosPorPlataforma(String plataforma) {
		
	    List<Producto> productos = devolverAllProductos();
	    List<Producto> productosFiltrados = new ArrayList<>();
	    
	    for (Producto producto : productos) {
	    	
	        if (producto instanceof Consola) {
	        	
	            Consola consola = (Consola) producto;
	            
	            if (consola.getPlataforma().getDescripcion().contains(plataforma)) {
	            	
	                productosFiltrados.add(consola);
	            }
	        } else if (producto instanceof VideoJuego) {
	        	
	            VideoJuego videojuego = (VideoJuego) producto;
	            
	            if (videojuego.getPlataforma().getDescripcion().contains(plataforma)) {
	            	
	                productosFiltrados.add(videojuego);
	            }
	        }
	    }

	    return productosFiltrados;
	}
	
	
	*/
	//veo mas logico usar aqui el iterator para borrar que crear otro array y añadir los productos
	public List<Producto> filtrarProductosPorPlataforma(String plataforma) {
	    List<Producto> productos = devolverAllProductos();
	    
	   
	    Iterator<Producto> iterator = productos.iterator();
	    
	    while (iterator.hasNext()) {
	        Producto producto = iterator.next();
	        
	        if (producto instanceof Consola) {
	            Consola consola = (Consola) producto;
	            
	            if (!consola.getPlataforma().getDescripcion().contains(plataforma)) {
	           
	            iterator.remove();
	            }
	        } else if (producto instanceof VideoJuego) {
	            VideoJuego videojuego = (VideoJuego) producto;
	            
	      if (!videojuego.getPlataforma().getDescripcion().contains(plataforma)) {
	          
	                iterator.remove();
	            }
	        }
	    }

	    return productos;
	}
	
	
	public  List<VideoJuego> devolverIdV(String serialNumber) {
	    List<VideoJuego> productos = devolverVideoJuegos(); 
	    Iterator<VideoJuego> iter = productos.iterator();
	    
	    while (iter.hasNext()) {
	    	VideoJuego producto = iter.next();
	        if (!producto.getSerialNumber().equals(serialNumber)) {
	            iter.remove();
	        }
	    }
		return  productos;
	   }
	
	public  List<Perifericos> devolverIdP(String serialNumber) {
	    List<Perifericos> productos = devolverAllPerifericos(); 
	    List<Perifericos> perifericosFiltrados = new ArrayList<>(); 
	    
	    for(Perifericos perifericos : productos) {
	    	
	    	if (perifericos.getSerialNumber().equals(serialNumber)) {
	    		perifericosFiltrados.add(perifericos);
			}
	    	
	    }
	   
	    
	   
	    return perifericosFiltrados;
		
	   }
	
	 private int encontrarUltimaId() {
		 ArrayList<Producto> productos = (ArrayList<Producto>) devolverAllProductos();
	        int id = 0;
	        for (Producto producto : productos) {
	        
	            if (producto.getId() > id) {
	                id = producto.getId();
	            }
	        }
	        return id;
	    }
	
	public boolean Insertar(Producto p) {
		
		
		ArrayList<Producto> productos = (ArrayList<Producto>) devolverAllProductos();
		
		
		
		boolean estado = false;
		 System.out.println ("1");
		 if (productos.isEmpty()) {
			 System.out.println ("Lista vacia");
			 productos.add(p);
			 guardarProductoTxt(productos);

			 estado = true;
			
		}
		 else 
		 {
			 boolean existe = false;
			 for (Producto producto : productos) {
				 System.out.println ("2");
				if (producto.getSerialNumber().equals(p.getSerialNumber()) || producto.getId() == p.getId()) {
					System.out.println ("El numero de serie ya existe");
					System.out.println ("3");
					existe = true;
 
				}
				
			}
			 if(existe == false) {
				 System.out.println ("4");
				 System.out.println (p);
				 productos.add(p);
				 guardarProductoTxt(productos);
				 estado = true;
			 }

		 }
		 	
		return estado;

	}
	
public void guardarProductoTxt(ArrayList<Producto> produc) {
		
		
               
        BufferedWriter br = null;
        

        try {
        	br = new BufferedWriter(new FileWriter(path, false));
        	for (Producto p : produc) {
        		
        		if (p instanceof Consola) {
    	            Consola consola = (Consola) p;
    	            
    	            br.write(consola.getNombre() + ", " + consola.getSerialNumber() + ", " + consola.getDescripcion() + ", " +
    	            		consola.getPrecio() + ", " + consola.getFechaLanzamiento() + ", " + consola.getEdicion() + ", " + consola.getPlataforma() + ", " + consola.isNuevo() + "\n");
    	       
    	            }
        		
        		if (p instanceof VideoJuego) {
        			VideoJuego v = (VideoJuego) p;
    	            
    	            br.write(v.getNombre() + ", " + v.getSerialNumber() + ", " + v.getDescripcion() + ", " +
    	            		v.getPrecio() + ", " + v.getFechaLanzamiento() + ", " + v.getEdicion() + ", " + v.getGenero() + ", " + v.getPlataforma()
    	            		+ ", " + v.isDigital() + ", " + v.isNuevo() + "\n");
    
    	            }
        		
        		if (p instanceof Perifericos) {
        			Perifericos pe = (Perifericos) p;
    	            
    	            br.write(pe.getNombre() + ", " + pe.getSerialNumber() + ", " + pe.getDescripcion() + ", " +
    	            		pe.getPrecio() + ", " + pe.getFechaLanzamiento() + ", " + pe.getEdicion() + ", " + pe.getTipoDispositivo()+ ", " + pe.isNuevo()
    	            		+ ", " + pe.isWireless() + ", " + pe.getMarca() + "\n");
    
    	            }
        		else {
        			
        			br.write(p.getNombre() + ", " + p.getSerialNumber() + ", " + p.getDescripcion() + ", " +
    	            		p.getPrecio() + ", " + p.getFechaLanzamiento() + ", " + p.getEdicion() + "\n") ;
        			
        		}
        		
        		
                
            }
        	br.close();

            
        } catch (IOException e) {

            System.out.println("Error al escribir");

            e.printStackTrace();
        } 
        
     }

	




    }


	

