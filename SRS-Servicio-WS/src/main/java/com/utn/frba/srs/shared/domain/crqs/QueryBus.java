package com.utn.frba.srs.shared.domain.crqs;

public interface QueryBus {
	public <T> T ask(Query<T> query) throws Exception;

	
}
