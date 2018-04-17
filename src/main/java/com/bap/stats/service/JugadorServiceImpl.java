package com.bap.stats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.stats.model.Jugador;
import com.bap.stats.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	private JugadorRepository repoJugador;
	
	@Override
	public void guardarJugador(Jugador jugador) {
		repoJugador.save(jugador);
	}

	@Override
	public List<Jugador> listarJugadores() {
		return repoJugador.findAll();
	}

	@Override
	public Optional<Jugador> buscarJugador(Long id) {
		return repoJugador.findById(id);
	}

	@Override
	public void eliminarJugador(Long id) {
		repoJugador.deleteById(id);
	}

	@Override
	public Boolean existeJugador(Long id) {
		return repoJugador.existsById(id);
	}

}
