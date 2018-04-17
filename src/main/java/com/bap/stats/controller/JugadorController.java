package com.bap.stats.controller;

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

import com.bap.stats.model.Jugador;
import com.bap.stats.service.JugadorService;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;

	@GetMapping
	public ResponseEntity<List<Jugador>> obtenerJugadores() {
		List<Jugador> jugadores = jugadorService.listarJugadores();

		if (jugadores.isEmpty()) {
			return new ResponseEntity<List<Jugador>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Jugador>>(jugadores, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable("id") Long id) {
		Optional<Jugador> jugador = jugadorService.buscarJugador(id);
		if (jugador.isPresent()) {
			return new ResponseEntity<Jugador>(jugador.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Jugador>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<String> guardarJugador(@RequestBody Jugador jugador) {
		if (jugador.getId() == null) {
			if (jugador.getNombre() != null && jugador.getCorreo() != null && jugador.getEsCapitan() != null) {
				jugadorService.guardarJugador(jugador);
				return new ResponseEntity<String>("OK", HttpStatus.CREATED);
			}
			return new ResponseEntity<String>(
					"Ocurrio un error al guardar el jugador, se debe asignar el nombre, el correo y si es capitan.",
					HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ocurrio un error al guardar el jugador, se debe asignar el ID como null",
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarEquipo(@PathVariable("id") Long id, @RequestBody Jugador jugador) {
		if (Long.valueOf(id) == null) {
			return new ResponseEntity<String>(
					"Ocurrio un error al actualizar el jugador: se esta signando un identificador incorrecto #" + id,
					HttpStatus.BAD_REQUEST);
		}

		if (jugador.getNombre() == null || jugador.getCorreo() == null || jugador.getEsCapitan() == null) {
			return new ResponseEntity<String>(
					"Ocurrio un error al guardar el jugador, se debe asignar el nombre, el correo y si es capitan.",
					HttpStatus.CREATED);

		}
		jugador.setId(id);
		jugadorService.guardarJugador(jugador);
		return new ResponseEntity<String>("Registro actualizado correctamente", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarJugador(@PathVariable("id") Long id) {
		if (jugadorService.existeJugador(id)) {
			jugadorService.eliminarJugador(id);
			return new ResponseEntity<String>("Jugador #" + id + " eliminado correctamente", HttpStatus.OK);
		}

		return new ResponseEntity<String>("No es posible eliminar el jugador: el identificador no existe",
				HttpStatus.BAD_REQUEST);
	}

}
