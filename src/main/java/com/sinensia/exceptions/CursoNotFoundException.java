package com.sinensia.exceptions;

import java.io.Serializable;

/**
 * Excepcion personalizada
 * 
 *@see com.sinensia.service.CursoServiceImpl
 */
public class CursoNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public CursoNotFoundException(String message) {
		super(message);
	}

}
