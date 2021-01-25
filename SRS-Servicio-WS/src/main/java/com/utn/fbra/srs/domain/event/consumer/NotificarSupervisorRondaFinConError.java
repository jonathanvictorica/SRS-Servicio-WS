package com.utn.fbra.srs.domain.event.consumer;

import com.google.gson.Gson;
import com.utn.fbra.srs.domain.event.producer.RondaFinalizadaConErrorED;
import com.utn.fbra.srs.shared.domain.EventDomainConsumer;
import com.utn.fbra.srs.shared.domain.ResultadoEDConsumer;

public class NotificarSupervisorRondaFinConError  extends EventDomainConsumer {

	@Override
	public String[] eventoDominioEscuchar() {
		return new String[] { "RondaFinalizadaConErrorED" };
	}

	@Override
	public ResultadoEDConsumer ejecutar(String datos) {
		try {
			RondaFinalizadaConErrorED rondaFinalizadaConErrorED = new Gson().fromJson(datos, RondaFinalizadaConErrorED.class);
			return ResultadoEDConsumer.ok();
		} catch (Exception e) {
			return ResultadoEDConsumer.error(e.getMessage());
		}
	}

}
