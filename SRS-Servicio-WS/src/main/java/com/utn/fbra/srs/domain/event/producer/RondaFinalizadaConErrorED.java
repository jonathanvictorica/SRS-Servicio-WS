package com.utn.fbra.srs.domain.event.producer;

import com.utn.fbra.srs.shared.domain.EventDomain;

public class RondaFinalizadaConErrorED extends EventDomain{

	@Override
	public String eventName() {
		return "RondaFinalizadaConErrorED";
	}

}
