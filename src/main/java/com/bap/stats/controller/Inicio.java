package com.bap.stats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Inicio {
	
	@GetMapping("/inicio")
	public String bienvenido() {
		return "Bienvenido a la API STATS v1";			
	}

}
