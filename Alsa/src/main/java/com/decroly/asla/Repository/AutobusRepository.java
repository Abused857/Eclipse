package com.decroly.asla.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.decroly.asla.Model.Autobus;


@Repository
	
	public interface AutobusRepository extends JpaRepository<Autobus,byte[]>
	{
		 


}