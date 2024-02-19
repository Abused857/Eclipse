package com.decroly.facturacion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decroly.facturacion.Model.Cliente;





public interface ClienteRepository extends JpaRepository<Cliente,String>
{

}