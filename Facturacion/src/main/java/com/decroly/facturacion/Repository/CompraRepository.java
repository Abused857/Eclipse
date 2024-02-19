package com.decroly.facturacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.decroly.facturacion.Model.Compra;

public interface CompraRepository extends JpaRepository<Compra,String>
{

}
