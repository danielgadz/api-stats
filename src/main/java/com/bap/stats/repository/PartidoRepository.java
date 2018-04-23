package com.bap.stats.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bap.stats.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
	
	  @Query("from Partido p where p.fecha = ?1")
	  Optional<Partido> buscarPartidoPorFecha(Date fecha);
	  
	  @Query("from Partido p where p.id = ?1 and p.equipo_local = ?2 or p.equipo_visita = ?2")
	  Optional<Partido> buscarPartidoPorEquipo(Long id, Long id_equipo);

}
