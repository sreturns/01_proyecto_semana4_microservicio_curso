package com.sinensia.service;

import java.util.List;

import com.sinensia.model.Curso;

public interface CursoService {

	Curso getByName(String nombre);

	List<Curso> getIfAvailable();
	
	List<Curso> getAll();

	List<Curso> deleteById(int idCurso);

	void update(Curso curso);

	List<Curso> save(Curso curso);

	public List<Curso> getListType(Boolean avaiables);

}
