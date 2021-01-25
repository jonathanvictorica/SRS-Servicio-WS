package com.utn.fbra.srs.shared.domain;

public abstract class EventDomainConsumer {

	public abstract String[] eventoDominioEscuchar();

	public abstract ResultadoEDConsumer ejecutar(String datos);
}
