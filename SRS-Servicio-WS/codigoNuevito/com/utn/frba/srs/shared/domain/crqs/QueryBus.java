package com.utn.frba.srs.shared.domain.crqs;

import com.utn.frba.srs.shared.domain.DomainException;

public interface QueryBus {
	public <T> T ask(Query<T> query) throws DomainException;

	
}
