package com.decroly.asla.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.decroly.asla.Model.Ticket;

@Repository

public interface TicketRepository extends JpaRepository<Ticket,byte[]>
{
	 


}