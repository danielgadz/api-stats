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
import org.springframework.web.bind.annotation.RestController;

import com.bap.stats.model.Equipo;
import com.bap.stats.service.EquipoService;

@RestController
public class EquipoController {

	@Autowired
	private EquipoService equipoService;

	@GetMapping("/equipos")
	public ResponseEntity<List<Equipo>> obtenerEquipos() {
		return new ResponseEntity<List<Equipo>>(equipoService.listarEquipos(), HttpStatus.OK);
	}

	@GetMapping("/equipos/{id}")
	public ResponseEntity<Optional<Equipo>> obtenerEquipoPorId(@PathVariable("id") Long id) {

		if (equipoService.existeEquipo(id)) {
			return new ResponseEntity<Optional<Equipo>>(equipoService.buscarEquipo(id), HttpStatus.OK);
		}

		return new ResponseEntity<Optional<Equipo>>(HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/equipos")
	public ResponseEntity<String> guardarEquipo(@RequestBody Equipo equipo) {

		if (equipo.getId() == null) {
			if (equipo.getNombre() != null) {
				equipoService.guardarEquipo(equipo);
				return new ResponseEntity<String>("Registro creado correctamente", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("Ocurrio un error al guardar el equipo: se debe asignar un NOMBRE",
						HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>("Ocurrio un error al guardar el equipo, se debe asignar el ID como null",
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/equipos/{id}")
	public ResponseEntity<String> actualizarEquipo(@PathVariable("id") Long id, @RequestBody Equipo equipo) {
		if (Long.valueOf(id) == null) {

			return new ResponseEntity<String>(
					"Ocurrio un error al actualizar el equipo: se esta signando un identificador incorrecto #" + id,
					HttpStatus.BAD_REQUEST);
		}

		equipo.setId(id);
		equipoService.guardarEquipo(equipo);
		return new ResponseEntity<String>("Registro actualizado correctamente", HttpStatus.OK);

	}

	@DeleteMapping("/equipos/{id}")
	public ResponseEntity<String> eliminarEquipo(@PathVariable("id") Long id) {
		if (equipoService.existeEquipo(id)) {
			equipoService.eliminarEquipo(id);
			return new ResponseEntity<String>("Equipo #" + id + " eliminado correctamente" , HttpStatus.OK);
		}

		return new ResponseEntity<String>("No es posible eliminar el equipo: el identificador no existe", HttpStatus.BAD_REQUEST);
	}
}
