package com.example.Dawnesa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Dawnesa.Model.Cine;
import com.example.Dawnesa.Model.Sala;

public interface SalaRepository extends JpaRepository<Sala,String>
{
	
	public List<Sala> findByCodCine(Cine codCine);
	
	public List<Sala> findByAforoGreaterThanEqual(int aforo);
	
	

}