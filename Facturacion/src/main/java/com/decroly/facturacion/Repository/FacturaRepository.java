package com.decroly.facturacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.decroly.facturacion.Model.Factura;

public interface FacturaRepository extends JpaRepository<Factura,String>
{

}
