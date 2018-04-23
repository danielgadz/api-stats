package com.bap.stats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.stats.model.Resultado;
import com.bap.stats.repository.ResultadoRepository;

@Service
public class ResultadoServiceImpl implements ResultadoService {

	@Autowired
	private ResultadoRepository repoResultado;

	@Override
	public void guardarResultado(Resultado resultado) {
		repoResultado.save(resultado);

	}

	@Override
	public List<Resultado> listarResultados() {
		return repoResultado.findAll();

	}

	@Override
	public Optional<Resultado> buscarResultado(Long id) {
		return repoResultado.findById(id);
	}

	@Override
	public void eliminarResultado(Long id) {
		repoResultado.deleteById(id);

	}
	
	@Override
	public Boolean existeResultado(Long id) {
		return repoResultado.existsById(id);
	}

}
