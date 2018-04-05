package com.bap.stats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.stats.model.Equipo;
import com.bap.stats.service.EquipoService;

@RestController
public class EquipoController {

	@Autowired
	private EquipoService equipoService;
	
	@PostMapping("/equipos")
	public ResponseEntity<String> guardaEquipo() {
		Equipo equipo = new Equipo("Mi Tercer Equipo", "Dany", "/TMP/DANY.PNG");
		equipoService.guardarEquipo(equipo);
		return new ResponseEntity<String>("OK", HttpStatus.CREATED);
	}
	
	@GetMapping("/equipos")
	public List<Equipo> obtenerEquipos() {
		return equipoService.listarEquipos();
	}
}
