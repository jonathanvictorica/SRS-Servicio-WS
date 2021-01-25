package com.utn.frba.srs.shared.domain;

import java.util.List;

public interface DomainEventBUS {

	public void publish(List<DomainEvent> list);
}
