package com.bap.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bap.stats.service.EquipoService;

@RestController
public class Inicio {

	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/inicio")
	public String bienvenido() {
		return "Bienvenido a la API STATS v1";			
	}

}
