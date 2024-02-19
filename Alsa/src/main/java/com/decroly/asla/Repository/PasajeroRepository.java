package com.decroly.asla.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decroly.asla.Model.Pasajero;
import com.decroly.asla.Model.Ruta;

public interface PasajeroRepository extends JpaRepository<Pasajero,byte[]>
	{

	}