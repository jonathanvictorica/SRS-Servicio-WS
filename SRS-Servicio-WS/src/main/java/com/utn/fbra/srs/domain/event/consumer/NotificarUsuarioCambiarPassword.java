package com.utn.fbra.srs.domain.event.consumer;

import com.google.gson.Gson;
import com.utn.fbra.srs.domain.event.producer.UsuarioCambiarPasswordED;
import com.utn.fbra.srs.shared.domain.EventDomainConsumer;
import com.utn.fbra.srs.shared.domain.ResultadoEDConsumer;

public class NotificarUsuarioCambiarPassword extends EventDomainConsumer {

	@Override
	public String[] eventoDominioEscuchar() {
		return new String[] { "UsuarioCambiarPasswordED" };
	}

	@Override
	public ResultadoEDConsumer ejecutar(String datos) {
		try {
			UsuarioCambiarPasswordED usuarioCreadoED = new Gson().fromJson(datos, UsuarioCambiarPasswordED.class);
			return ResultadoEDConsumer.ok();
		} catch (Exception e) {
			return ResultadoEDConsumer.error(e.getMessage());
		}
	}

}
