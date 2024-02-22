package com.example.Dawnesa.Repository;

import java.util.List;

import org.apache.el.parser.AstInteger;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Dawnesa.Model.Butacas;
import com.example.Dawnesa.Model.Cine;
import com.example.Dawnesa.Model.Sala;
import com.example.Dawnesa.Model.Sesiones;

public interface SesionesRepository extends JpaRepository<Sesiones,Integer >
{
	
	
}