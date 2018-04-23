package com.bap.stats.service;

import java.util.List;
import java.util.Optional;

import com.bap.stats.model.Resultado;

public interface ResultadoService {
	
	void guardarResultado(Resultado resultado);
	
	List<Resultado> listarResultados();
	
	Optional<Resultado> buscarResultado(Long id);
	
	void eliminarResultado(Long id);
	
	Boolean existeResultado(Long id);
	
}
