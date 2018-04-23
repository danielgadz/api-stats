package com.bap.stats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.stats.model.Resultado;
import com.bap.stats.service.ResultadoService;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

	@Autowired
	private ResultadoService resultadoService;

	@GetMapping
	public ResponseEntity<List<Resultado>> obtenerResultados() {
		return new ResponseEntity<List<Resultado>>(resultadoService.listarResultados(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Resultado>> obtenerResultadoPorId(@PathVariable("id") Long id) {
		if (resultadoService.existeResultado(id)) {
			return new ResponseEntity<Optional<Resultado>>(resultadoService.buscarResultado(id), HttpStatus.OK);
		}

		return new ResponseEntity<Optional<Resultado>>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarResultado(@PathVariable("id") Long id, @RequestBody Resultado resultado) {
		if (Long.valueOf(id) == null) {
			return new ResponseEntity<String>("Ocurrió error al actualizar el equipo", HttpStatus.BAD_REQUEST);
		}

		resultado.setId(id);
		resultadoService.guardarResultado(resultado);
		return new ResponseEntity<String>("Registro Actualizado correctamente", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> guardaResultado(@RequestBody Resultado resultado) {
		if (resultado.getId() == null) {
			resultadoService.guardarResultado(resultado);
			return new ResponseEntity<String>("Registro creado correctamente", HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("Ocurrio un error al guardar equipo", HttpStatus.BAD_REQUEST);
	}

}
