package com.bap.stats.service;

import java.util.List;

import com.bap.stats.model.Equipo;

public interface EquipoService {
	
	void guardarEquipo(Equipo equipo);
	
	List<Equipo> listarEquipos();
	
	Equipo buscarEquipo(Long id);
	
	void eliminarEquipo(Long id);
	
}
