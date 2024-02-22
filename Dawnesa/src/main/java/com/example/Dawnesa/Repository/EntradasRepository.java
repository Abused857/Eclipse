package com.example.Dawnesa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Dawnesa.Model.Entradas;
import com.example.Dawnesa.Model.Peliculas;
import com.example.Dawnesa.Model.Sesiones;

public interface EntradasRepository extends JpaRepository<Entradas, Integer>
{
	List<Entradas> findByIdSesion(Sesiones idSesion);
}
