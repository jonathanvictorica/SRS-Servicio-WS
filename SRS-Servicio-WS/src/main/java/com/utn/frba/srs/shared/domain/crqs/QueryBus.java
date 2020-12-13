package com.utn.frba.srs.shared.domain.crqs;

public interface QueryBus {
	public  <T> T handle(Query<T> query) throws Exception;
}
