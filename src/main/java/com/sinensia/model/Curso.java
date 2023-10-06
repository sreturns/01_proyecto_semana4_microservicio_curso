package com.sinensia.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Nuestra clase mapeada con la tabla cursos
 * 
 * @see com.sinensia.dao.CursoDao
 */
@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	private String disponibilidad;
	private int plazas;

	public Curso() {
	}

	/**
	 * 
	 * @param nombre
	 * @param duracion
	 * @param precio
	 * @param disponibilidad
	 * @param plazas
	 */
	public Curso(String nombre, int duracion, double precio, String disponibilidad, int plazas) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		this.plazas = plazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponibilidad, duracion, idCurso, nombre, precio, plazas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(disponibilidad, other.disponibilidad) && duracion == other.duracion
				&& idCurso == other.idCurso && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPlazas() {
		return plazas;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
