package com.utn.fbra.srs.shared.domain;

import java.util.UUID;

import com.google.gson.Gson;

public abstract class EventDomain {

	public abstract String eventName();

	protected UUID eventoID = UUID.randomUUID();

	public String data() {
		return new Gson().toJson(this, getClass());
	}

}
