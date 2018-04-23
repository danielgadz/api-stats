package com.bap.stats.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.stats.model.Partido;
import com.bap.stats.repository.PartidoRepository;

@Service
public class PartidoServiceImpl implements PartidoService {

	@Autowired
	private PartidoRepository repoPartido;

	@Override
	public void guardarPartido(Partido partido) {
		repoPartido.save(partido);

	}

	@Override
	public List<Partido> listarPartidos() {
		return repoPartido.findAll();

	}

	@Override
	public Optional<Partido> buscarPartido(Long id) {
		return repoPartido.findById(id);
	}

	@Override
	public Optional<Partido> buscarPartidoPorFecha(Date fecha) {
		return repoPartido.buscarPartidoPorFecha(fecha);
	}

	@Override
	public void eliminarPartido(Long id) {
		repoPartido.deleteById(id);

	}

	@Override
	public Boolean existePartido(Long id) {
		return repoPartido.existsById(id);
	}

	@Override
	public Optional<Partido> buscarPartidoPorEquipo(Long id, Long id_equipo) {
		return repoPartido.buscarPartidoPorEquipo(id, id_equipo);
	}

}
