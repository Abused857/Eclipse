package com.example.Dawnesa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Dawnesa.Model.Cine;
import com.example.Dawnesa.Model.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas, String>
{
	
}
