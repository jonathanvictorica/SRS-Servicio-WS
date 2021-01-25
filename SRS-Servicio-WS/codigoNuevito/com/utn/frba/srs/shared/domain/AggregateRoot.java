package com.utn.frba.srs.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class AggregateRoot {
	protected List<DomainEvent> events = new ArrayList<>();

	public List<DomainEvent> pullEventDomain() {
		List<DomainEvent> aux = events;
		this.events = new ArrayList<>();
		return aux;

	}
}
