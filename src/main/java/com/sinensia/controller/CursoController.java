package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.model.Curso;
import com.sinensia.service.CursoService;

/**
 * Manejamos todos los metodos Http a traves del @RestController
 * 
 * @author Sergio
 * @see com.sinensia.controller.CursoController
 * @see com.sinensia.service.CursoServiceImpl
 * @see com.sinensia.service.CursoService
 */
@RestController
public class CursoController {

	/**
	 * Inyectamos nuestro servicio
	 */
	@Autowired
	private CursoService service;

	/**
	 * 
	 * @param avaiables
	 * @return
	 */
	@GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> getAll(@RequestParam(required = false) boolean avaiables) {
		List<Curso> list = service.getListType(avaiables);

		if (list == null || list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	@GetMapping(value = "curso/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getByName(@PathVariable("nombre") String nombre) {
		Curso curso = service.getByName(nombre);

		if (curso == null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(curso);
	}

	/**
	 * 
	 * @param curso
	 * @return
	 */
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> save(@RequestBody Curso curso) {
		List<Curso> list = service.save(curso);
		return ResponseEntity.ok(list);
	}

	/**
	 * 
	 * @param curso
	 */
	@PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Curso curso) {
		service.update(curso);
	}

	/**
	 * 
	 * @param idCurso
	 * @return
	 */
	@DeleteMapping(value = "curso/{idCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> deleteById(@PathVariable("idCurso") int idCurso) {
		try {
			if (idCurso < 0) {
				throw new IllegalArgumentException();
			}

			List<Curso> list = service.deleteById(idCurso);

			if (list == null || list.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(list);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

}
