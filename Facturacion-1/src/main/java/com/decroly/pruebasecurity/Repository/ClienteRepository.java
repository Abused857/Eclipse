package com.decroly.pruebasecurity.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decroly.pruebasecurity.Model.Cliente;







public interface ClienteRepository extends JpaRepository<Cliente,String>
{

}