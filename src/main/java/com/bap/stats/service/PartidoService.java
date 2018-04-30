package com.bap.stats.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bap.stats.model.Partido;

public interface PartidoService {

	void guardarPartido(Partido partido);

	List<Partido> listarPartidos();

	Optional<Partido> buscarPartido(Long id);

	Optional<Partido> buscarPartidoPorFecha(Date fecha);

	Optional<Partido> buscarPartidoPorEquipo(Long id, Long id_equipo);

	void eliminarPartido(Long id);

	Boolean existePartido(Long id);

}
