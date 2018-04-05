package com.bap.stats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bap.stats.model.Equipo;
import com.bap.stats.service.EquipoService;

@RestController
public class Inicio {

	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/inicio")
	public List<Equipo> bienvenido() {
		
		Equipo equipo = new Equipo("Mi Tercer Equipo", "dany", "/tmp/dany.png");
		equipoService.guardarEquipo(equipo);
		return equipoService.listarEquipos();
		
	}

}
