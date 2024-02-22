package com.example.Dawnesa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Dawnesa.Model.Butacas;
import com.example.Dawnesa.Model.Cine;
import com.example.Dawnesa.Model.Sala;

public interface ButacasRepository extends JpaRepository<Butacas,String>
{
	
	public  List<Butacas> findByCodSala(Sala codSala);
	

	

}