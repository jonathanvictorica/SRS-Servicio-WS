package com.utn.frba.srs.shared.domain;

public class NotFoundException extends Exception {

	public NotFoundException(String mensaje) {
		super("No encontrado con el id %s "+mensaje);
		
	}
}
