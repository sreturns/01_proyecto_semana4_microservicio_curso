package com.sinensia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.dao.CursoDao;
import com.sinensia.model.Curso;

/**
 * Nuestro @Service
 *
 * @see com.sinensia.service.CursoService
 * @see com.sinensia.controller.CursoController
 * @see com.sinensia.dao.CursoDao
 */
@Service
public class CursoServiceImpl implements CursoService {

	/**
	 * Inyectamos nuestro dao para poder acceder a los metodos Crud
	 */
	@Autowired
	private CursoDao dao;

	/**
	 * 
	 * @return List
	 */
	@Override
	public List<Curso> getIfAvailable() {
		return dao.getIfAvailable();
	}

	/**
	 * 
	 * @param nombre
	 */
	@Override
	public Curso getByName(String nombre) {
		return dao.getByName(nombre);
	}

	/**
	 * 
	 */
	@Override
	public List<Curso> getAll() {
		return dao.findAll();
	}

	/**
	 * 
	 * @param idCurso
	 */
	@Override
	public List<Curso> deleteById(int idCurso) {
		try {
			if (idCurso < 0) {
				throw new IllegalArgumentException("El numero debe ser mayor a 0");
			}
			dao.deleteById(idCurso);

		} catch (IllegalArgumentException e) {
			System.out.println("Error " + e);
		}
		return dao.findAll();
	}

	/**
	 * 
	 * @param curso
	 */
	@Override
	public void update(Curso curso) {
		try {
			if (curso == null) {
				throw new IllegalArgumentException();
			}
			if (curso.getPlazas() <= 0) {
				curso.setDisponibilidad("no");
			}
			dao.save(curso);
		} catch (IllegalArgumentException e) {

		}

	}

	/**
	 * 
	 * @param curso
	 */
	@Override
	public List<Curso> save(Curso curso) {
		try {
			if (curso == null) {
				throw new IllegalArgumentException();
			}
			if (curso.getPlazas() == 0) {
				curso.setDisponibilidad("no");
			} else {
				curso.setDisponibilidad("si");
			}
			dao.save(curso);
		} catch (IllegalArgumentException e) {

		}
		return dao.findAll();
	}

	/**
	 * 
	 * @param avaiables
	 */
	public List<Curso> getListType(Boolean avaiables) {
		List<Curso> cursos;

		if (Boolean.TRUE.equals(avaiables)) {
			cursos = getIfAvailable();
		} else {
			cursos = getAll();
		}
		return cursos;
	}
}
