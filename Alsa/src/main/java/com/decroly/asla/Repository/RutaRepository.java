package com.decroly.asla.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decroly.asla.Model.Ruta;

@Repository
	
	public interface RutaRepository extends JpaRepository<Ruta,byte[]>
	{
		 


}


