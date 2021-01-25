package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.vo.NumeroVO;
import com.utn.fbra.srs.domain.vo.UbicacionVO;
import com.utn.fbra.srs.shared.domain.ValueObject;

public class RondaRutaVO extends ValueObject{

	private UbicacionVO puntoInicial;
	private UbicacionVO puntoFinal;
	private NumeroVO ordenEjecucion;

	public RondaRutaVO(UbicacionVO puntoInicial, UbicacionVO puntoFinal, NumeroVO ordenEjecucion) {
		super();
		this.puntoInicial = puntoInicial;
		this.puntoFinal = puntoFinal;
		this.ordenEjecucion = ordenEjecucion;
	}

}
