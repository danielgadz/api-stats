package com.bap.stats.service;

import java.util.List;
import java.util.Optional;

import com.bap.stats.model.Jugador;

public interface JugadorService {

	void guardarJugador(Jugador jugador);

	List<Jugador> listarJugadores();

	Optional<Jugador> buscarJugador(Long id);

	void eliminarJugador(Long id);
	
	Boolean existeJugador(Long id);
	
}
