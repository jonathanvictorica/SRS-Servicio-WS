package com.utn.fbra.srs.domain.model.ronda;

import java.util.ArrayList;
import java.util.List;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.shared.domain.ValueObject;

public class RondaRutasVO extends ValueObject{
	
	private List<RondaRutaVO> caminos = new ArrayList<>();

	public void validarCaminoRonda() throws DomainException {
		if(this.caminos.isEmpty()) {
			throw new DomainException("La ronda debe tener al menos una ruta configurada");
		}	
	}

	public void modificarRutas(List<RondaRutaVO> caminos) {
		this.caminos.clear();
		this.caminos=caminos;
		
	}

	public List<RondaRutaVO> getRutas() {
		return this.caminos;
	}

}
