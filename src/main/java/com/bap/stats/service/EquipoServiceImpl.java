package com.bap.stats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.stats.model.Equipo;
import com.bap.stats.repository.EquipoRepository;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoRepository repoEquipo;

	@Override
	public void guardarEquipo(Equipo equipo) {
		repoEquipo.save(equipo);
	}

	@Override
	public List<Equipo> listarEquipos() {
		return (List<Equipo>) repoEquipo.findAll();
	}

	@Override
	public Optional<Equipo> buscarEquipo(Long id) {
		return repoEquipo.findById(id);
	}

	@Override
	public void eliminarEquipo(Long id) {
		repoEquipo.deleteById(id);

	}

	@Override
	public Boolean existeEquipo(Long id) {
		return repoEquipo.existsById(id);
	}

}
