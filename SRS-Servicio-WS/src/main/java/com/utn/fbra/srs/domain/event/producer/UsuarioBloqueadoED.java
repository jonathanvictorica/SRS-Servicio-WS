package com.utn.fbra.srs.domain.event.producer;

import com.utn.fbra.srs.shared.domain.EventDomain;

public class UsuarioBloqueadoED extends EventDomain {

	private String usuarioID;
	private String nombreApellido;
	private String nick;
	private String mail;

	public UsuarioBloqueadoED() {
		super();
	}

	public UsuarioBloqueadoED(String usuarioID, String nombreApellido, String nick, String mail) {
		super();
		this.usuarioID = usuarioID;
		this.nombreApellido = nombreApellido;
		this.nick = nick;
		this.mail = mail;
	}

	@Override
	public String eventName() {
		return "UsuarioBloqueadoED";
	}

}
