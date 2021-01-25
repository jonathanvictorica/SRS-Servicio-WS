package com.utn.fbra.srs.domain.event.consumer;

import com.google.gson.Gson;
import com.utn.fbra.srs.domain.event.producer.UsuarioCreadoED;
import com.utn.fbra.srs.shared.domain.EventDomainConsumer;
import com.utn.fbra.srs.shared.domain.ResultadoEDConsumer;

public class NotificarUsuarioCreado extends EventDomainConsumer {

	@Override
	public String[] eventoDominioEscuchar() {
		return new String[] { "UsuarioCreadoED" };
	}

	@Override
	public ResultadoEDConsumer ejecutar(String datos) {
		try {
			UsuarioCreadoED usuarioCreadoED = new Gson().fromJson(datos, UsuarioCreadoED.class);
			
			
			return ResultadoEDConsumer.ok();
		} catch (Exception e) {
			return ResultadoEDConsumer.error(e.getMessage());
		}
	}

}
