package com.bap.stats.service;

import java.util.List;
import java.util.Optional;

import com.bap.stats.model.Equipo;

public interface EquipoService {

	void guardarEquipo(Equipo equipo);

	List<Equipo> listarEquipos();

	Optional<Equipo> buscarEquipo(Long id);

	void eliminarEquipo(Long id);

	Boolean existeEquipo(Long id);

}
