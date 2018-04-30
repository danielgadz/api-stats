package com.bap.stats.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.stats.model.Partido;
import com.bap.stats.service.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	@Autowired
	private PartidoService partidoService;

	@GetMapping
	public ResponseEntity<List<Partido>> obtenerEquipos() {
		return new ResponseEntity<List<Partido>>(partidoService.listarPartidos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Partido>> obtenerPartidoPorId(@PathVariable("id") Long id) {
		if (partidoService.existePartido(id)) {
			return new ResponseEntity<Optional<Partido>>(partidoService.buscarPartido(id), HttpStatus.OK);
		}

		return new ResponseEntity<Optional<Partido>>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{fecha}")
	public ResponseEntity<Optional<Partido>> obtenerPartidoPorFecha(@PathVariable("fecha") Date fecha) {
		return new ResponseEntity<Optional<Partido>>(partidoService.buscarPartidoPorFecha(fecha), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/{id_equipo}")
	public ResponseEntity<Optional<Partido>> obtenerPartidoPorEquipo(@PathVariable("id") Long id, Long id_equipo) {
		return new ResponseEntity<Optional<Partido>>(partidoService.buscarPartidoPorEquipo(id, id_equipo), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarPartido(@PathVariable("id") Long id, @RequestBody Partido partido) {
		if (Long.valueOf(id) == null) {
			return new ResponseEntity<String>("Ocurrió error al actualizar el partido", HttpStatus.BAD_REQUEST);
		}

		partido.setId(id);
		partidoService.guardarPartido(partido);
		return new ResponseEntity<String>("Registro Actualizado correctamente", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> guardaPartido(@RequestBody Partido partido) {
		if (partido.getId() == null) {
			partidoService.guardarPartido(partido);
			return new ResponseEntity<String>("Registro creado correctamente", HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("Ocurrio un error al guardar partido", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarEquipo(@PathVariable("id") Long id) {
		if (partidoService.existePartido(id)) {
			partidoService.eliminarPartido(id);
			return new ResponseEntity<String>("Partido #" + id + " eliminado correctamente", HttpStatus.OK);
		}

		return new ResponseEntity<String>("No es posible eliminar el partido: el identificador no existe",
				HttpStatus.BAD_REQUEST);
	}
}
