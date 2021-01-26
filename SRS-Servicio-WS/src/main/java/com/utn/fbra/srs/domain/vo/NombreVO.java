package com.utn.fbra.srs.domain.vo;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.shared.domain.ValueObject;

public class NombreVO extends ValueObject<String> {

	public NombreVO(String nombre) throws DomainException {
		if (nombre == null || nombre.length() > 50) {
			throw new DomainException("El nombre no debe ser nulo y tener mayor a 50 caracteres");
		}
		this.valor = nombre;
	}



}
