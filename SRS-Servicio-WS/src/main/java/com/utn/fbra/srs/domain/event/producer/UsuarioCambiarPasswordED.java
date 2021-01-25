package com.utn.fbra.srs.domain.event.producer;

import com.utn.fbra.srs.shared.domain.EventDomain;

public class UsuarioCambiarPasswordED extends EventDomain {

	private String usuarioID;
	private String nombreApellido;
	private String nick;
	private String mail;

	public UsuarioCambiarPasswordED() {
		super();
	}

	public UsuarioCambiarPasswordED(String usuarioID, String nombreApellido, String nick, String mail) {
		super();
		this.usuarioID = usuarioID;
		this.nombreApellido = nombreApellido;
		this.nick = nick;
		this.mail = mail;
	}

	@Override
	public String eventName() {
		return "UsuarioCambiarPasswordED";
	}

}
