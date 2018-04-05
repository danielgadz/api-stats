package com.bap.stats.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		
		repoEquipo.save(equipo);	

	}

	@Override
	public List<Equipo> listarEquipos() {
		// TODO Auto-generated method stub
		return repoEquipo.findAll();
	}

	@Override
	public Equipo buscarEquipo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEquipo(Long id) {
		// TODO Auto-generated method stub
		
	}

}
