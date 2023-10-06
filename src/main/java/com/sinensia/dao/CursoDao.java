package com.sinensia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.model.Curso;

/**
 * Extendemos de JpaRepository
 * 
 * @see com.sinensia.service.CursoServiceImpl
 */
public interface CursoDao extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c where c.disponibilidad = 'si'")
	List<Curso> getIfAvailable();

	@Query("select c from Curso c where c.nombre = :nombre")
	Curso getByName(String nombre);

}
