package com.sinensia.exceptions;

import java.io.Serializable;

public class CursoNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public CursoNotFoundException(String message) {
		super(message);
	}

}
