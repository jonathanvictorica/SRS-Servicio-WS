package com.utn.fbra.srs.domain.event.consumer;

import com.google.gson.Gson;
import com.utn.fbra.srs.domain.event.producer.UsuarioBloqueadoED;
import com.utn.fbra.srs.shared.domain.EventDomainConsumer;
import com.utn.fbra.srs.shared.domain.ResultadoEDConsumer;

public class NotificarUsuarioBloqueado extends EventDomainConsumer {

	@Override
	public String[] eventoDominioEscuchar() {
		return new String[] { "UsuarioBloqueadoED" };
	}

	@Override
	public ResultadoEDConsumer ejecutar(String datos) {
		try {
			UsuarioBloqueadoED usuarioCreadoED = new Gson().fromJson(datos, UsuarioBloqueadoED.class);
			return ResultadoEDConsumer.ok();
		} catch (Exception e) {
			return ResultadoEDConsumer.error(e.getMessage());
		}
	}

}
